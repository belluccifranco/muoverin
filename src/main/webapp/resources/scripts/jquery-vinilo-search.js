(function($){

	//these methods are always called in the jq object context.
	var methods = {
		init: function(options) {
			var settings = $.extend(true, {}, $.fn.jqViniloSearch.defaults, options);

			return this.each(function(){
				var jqViniloSearchData = [],
					searchData = {},
					$elem = $(this),
					$form = $elem.find('form' + settings.formSelector),
					$formButton = $elem.find(settings.formButtonSelector),
					$list = $elem.find(settings.listSelector),
					$listContainer = $elem.find(settings.listContainerSelector),
					pages = 0,
					stopSearching = false,
					getData = function(idx) {
						if (typeof idx === 'undefined') {
							return jqViniloSearchData;
						}
						if ($.isNumeric(idx)) {
							idx = parseInt(idx, 10);
							if (idx >=0 && idx < jqViniloSearchData.length) {
								return jqViniloSearchData[idx];
							}
						}
						return null;
					},
					addData = function(data) {
						if (typeof data === 'undefined' || $.isFunction(data)) {
							return;
						}
						if ($.isArray(data)) {
							jqViniloSearchData = jqViniloSearchData.concat(data);
						} else {
							jqViniloSearchData.push(data);
						}
					},
					clearData = function() {
						while (jqViniloSearchData.length > 0) {
							jqViniloSearchData.pop();
						}
                        //jqViniloSearchData = [];
						$list.html('');
						pages = 0;
						searchData = {};
						stopSearching = false;
					},
					updateUI = function(data) {
						var i;
						if (typeof data === 'undefined' || $.isFunction(data)) {
							return;
						}
						if (!$.isArray(data)) {
							data = [data];
						}
						for (i = 0; i < data.length; i += 1) {
							$list.append('<li>' + settings.getDataElementHtml(data[i]) + '</li>');
						}
					},
					doSearch = function() {
						var url = $form.data('url'),
							hasAllEmptyValues = true,
							emptyValues = ['', null, undefined],
							idx, k;

						if (stopSearching) {
							return;
						}

						for (k in searchData) {
							idx = emptyValues.indexOf(searchData[k]);
							if (idx < 0) {
								hasAllEmptyValues = false;
								break;
							}
						};

						if (!hasAllEmptyValues) {
							searchData[settings.pageName] = pages + 1;
							$.ajax({
								url: url,
								data: searchData,
								dataType: 'json',
								success: function(data) {
									var length = data.data.length;
                                    pages += 1;
									if (length > 0) {
										addData(data.data);
										updateUI(data.data);
										if (length < 10) {
											stopSearching = true;
										}
									} else {
										stopSearching = true;
									}
								} 
							});
						}
                    },
                    search = function() {
                        clearData();
                        $.each($form.serializeArray(), function(k, v) {
                            searchData[v.name] = v.value;
                        });
                        doSearch();
                    };

				this.getData = getData;
				this.addData = addData;
				this.clearData = clearData;

				$form.on('submit', function(e){
                    search();
					e.preventDefault();
					e.stopPropagation();
				});

				$formButton.on('click', function(e){
					search();
					e.preventDefault();
				});

                $listContainer.on('scroll', function(){
                    var scrollPosition = $listContainer.scrollTop() + $listContainer.height(),
                        height = $list.outerHeight(true);
                    if (scrollPosition >= height) {
                        doSearch();
                    }
                });
			});
		}
	}
	
	$.fn.jqViniloSearch = function(methodOrOptions) {
		if (this.first().get(0)[methodOrOptions]) {
		//if (methods[methodOrOptions]) {
			//this methods are supposed to be applied to one jquery object. In this case the first
            return this.first().get(0)[methodOrOptions].apply(null, Array.prototype.slice.call(arguments, 1));
            //return methods[methodOrOptions].apply(this.first().get(0), Array.prototype.slice.call(arguments, 1));
        } else if ( $.isPlainObject(methodOrOptions) || !methodOrOptions ) {
            return methods.init.apply(this, arguments);
        } else {
            $.error( 'Method ' +  methodOrOptions + ' does not exist on jQuery.jqViniloSearch' );
        }    
	}

	$.fn.jqViniloSearch.defaults = {
		containerClass: 'jq-vinilo-search',
		formSelector: '.jq-vinilo-search-form',
		formButtonSelector: '.jq-vinilo-search-form-button',
		listContainerSelector: '.jq-vinilo-search-list-container',
		listSelector: '.jq-vinilo-search-list',
		pageName: 'index',
		getDataElementHtml: function(dataElement) {
			throw 'this function must be implemented.';
		}
	};
})(jQuery);
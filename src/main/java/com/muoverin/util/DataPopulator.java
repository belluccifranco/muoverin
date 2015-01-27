package com.muoverin.util;

import com.muoverin.model.Album;
import com.muoverin.model.Artist;
import com.muoverin.model.HostingAccount;
import com.muoverin.model.Link;
import com.muoverin.model.Song;
import com.muoverin.model.UserAccount;
import com.muoverin.model.UserRole;
import com.muoverin.service.UserAccountService;
import com.muoverin.service.AlbumService;
import com.muoverin.service.ArtistService;
import com.muoverin.service.HostingAccountService;
import com.muoverin.service.SongService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

public class DataPopulator {

    private final SongService songService;
    private final ArtistService artistService;
    private final AlbumService albumService;
    private final UserAccountService accountService;
    private final HostingAccountService hostingAccountService;

    @Autowired
    public DataPopulator(SongService songService, UserAccountService accountService,
            HostingAccountService hostingAccountService, ArtistService artistService,
            AlbumService albumService) {

        this.songService = songService;
        this.accountService = accountService;
        this.hostingAccountService = hostingAccountService;
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @PostConstruct
    public void initialize() {
        this.insertUsersWithRoles();
        this.insertHostingAccounts();
        this.insertArtists();
        this.insertAlbums();
        this.insertSongs();
    }

    private void insertUsersWithRoles() {
        UserRole roleCustomer = new UserRole("ROLE_CUSTOMER");
        List<UserRole> customerRoles = new ArrayList<>();
        customerRoles.add(roleCustomer);
        UserAccount userFacundo = new UserAccount("fssl2004@gmail.com", "e10adc3949ba59abbe56e057f20f883e", customerRoles);
        List<UserAccount> customerAccounts = new ArrayList<>();
        customerAccounts.add(userFacundo);
        roleCustomer.setUserAccounts(customerAccounts);
        userFacundo = accountService.save(userFacundo);
        customerRoles.clear();
        customerRoles.add(userFacundo.getUserRoles().get(0));
        UserAccount userFranco = new UserAccount("belluccifranco@gmail.com", "e10adc3949ba59abbe56e057f20f883e", customerRoles);
        customerAccounts.clear();
        customerAccounts.add(userFranco);
        customerRoles.get(0).setUserAccounts(customerAccounts);
        accountService.save(userFranco);
        customerRoles.clear();
        customerRoles.add(userFacundo.getUserRoles().get(0));
        UserAccount userTest = new UserAccount("test@test.com", "e10adc3949ba59abbe56e057f20f883e", customerRoles);
        customerAccounts.clear();
        customerAccounts.add(userTest);
        customerRoles.get(0).setUserAccounts(customerAccounts);
        accountService.save(userTest);
    }

    private void insertHostingAccounts() {
        HostingAccount hosting1 = new HostingAccount("https://g.api.mega.co.nz", "cuentavinilo01@gmail.com", "Ninguna01");
        hostingAccountService.save(hosting1);
    }

    private void insertArtists() {
        Artist acdc = new Artist("AC DC");
        Artist ledzeppelin = new Artist("Led Zeppelin");
        artistService.save(acdc);
        artistService.save(ledzeppelin);
    }

    private void insertAlbums() {
        Album album1 = new Album("Highway to Hell", "1979");
        List<Album> acdcAlbumes = new ArrayList<>();
        acdcAlbumes.add(album1);
        Artist artist1 = artistService.searchByName("AC DC");
        List<Artist> artistsHighwayToHell = new ArrayList<>();
        artistsHighwayToHell.add(artist1);
        artist1.setAlbums(acdcAlbumes);
        album1.setArtists(artistsHighwayToHell);
        albumService.save(album1);

        Album album2 = new Album("Presense", "1976");
        List<Album> ledZepplinAlbumes = new ArrayList<>();
        ledZepplinAlbumes.add(album2);
        Artist artist2 = artistService.searchByName("Led Zeppelin");
        List<Artist> artistsLedZeppelin = new ArrayList<>();
        artistsLedZeppelin.add(artist2);
        artist2.setAlbums(ledZepplinAlbumes);
        album2.setArtists(artistsLedZeppelin);
        albumService.save(album2);
    }

    private void insertSongs() {
        HostingAccount hosting1 = hostingAccountService.searchByUsername("cuentavinilo01@gmail.com");

        Link link1 = new Link("https://mega.co.nz/#!ilhghR7D!bXAvBGk_Z-7nFWZeHr0meC5Ce_4yFqHF38AnVmO7gew", hosting1);
        Link link2 = new Link("https://mega.co.nz/#!ipQ1HabR!eFikkFla4rIOqPpCJVgxlCSNaRoQGCadYk17qgBrFFY", hosting1);
        Link link3 = new Link("https://mega.co.nz/#!u05HDKSC!DauTn0lUVaUOjauoxXXqpk5Y4qYi3wVCA46XLZbontk", hosting1);
        Link link4 = new Link("https://mega.co.nz/#!yhATDbxL!Ujkb-jqdxc_r5RxNOVls-0Upik15bIiPp_W36hI6uO4", hosting1);
        Link link5 = new Link("https://mega.co.nz/#!DhRw1IjJ!aA30wnfpF7Z97DRRnZrSRHq51VpWoVI1UCj45YH-j4w", hosting1);
        Link link6 = new Link("https://mega.co.nz/#!n8AzSLSb!XJOUBCWK9K6Tux9W6JM_GGTswUQVuutzo2Fb8L2TGpw", hosting1);
        Link link7 = new Link("https://mega.co.nz/#!HshkSBrL!LbhwQz1kgPTSA8i-85rGmBVdEUwJwFIh-isoa7-JYW8", hosting1);
        Link link8 = new Link("https://mega.co.nz/#!esYkBQbQ!FdxakAVWP6A5sHWb4DOCj01i31UPkyMKV0by9Pb6Hps", hosting1);
        Link link9 = new Link("https://mega.co.nz/#!XghGjAYB!HMKf-Vt3hB9WICSa0Tak7Xxywo5TsX2FF8NMI8mo7Dk", hosting1);
        Link link10 = new Link("https://mega.co.nz/#!Tw4B0ZjL!WThKG0EqXIvrLeyzWVMT6ia_m1pec3NA18yeTnyBD1A", hosting1);
        Link link11 = new Link("https://mega.co.nz/#!OkxT2CQQ!VNGQzxRoTqbVLSGhnrTxjVVX_C1NHHJhjHgDwtzeUx0", hosting1);
        Link link12 = new Link("https://mega.co.nz/#!Osw2WTwD!fl6NTE1LbX7yq20hoLW9d1naZKt3g6ta6O_oucXNVTg", hosting1);
        Link link13 = new Link("https://mega.co.nz/#!20gSAAqa!ZwJG4QRJKJ75GLiueYfATivpz_laKt2Z2LMWQX2esH8", hosting1);
        Link link14 = new Link("https://mega.co.nz/#!v8wCXSIb!fdgHRHilmQW1olzTxZkiLlwkMsIyGZyKz3SwSpOnC8Q", hosting1);
        Link link15 = new Link("https://mega.co.nz/#!614k1BSQ!GzwglVZX0lO99bnl5IQcRArpwCVTYMnn7GERSJgNCyI", hosting1);
        Link link16 = new Link("https://mega.co.nz/#!TtpwiYIT!X9dvM0nA5XBI4nOlObLBOW_vKK52WsFJFG34WT6sSDY", hosting1);
        Link link17 = new Link("https://mega.co.nz/#!e95BlaID!aHdUkANGbgrHpi8eXk_gMUytaDMttmb3o52gwHLiXHU", hosting1);

        List<Link> links = new ArrayList<>();
        links.add(link1);
        links.add(link2);
        links.add(link3);
        links.add(link4);
        links.add(link5);
        links.add(link6);
        links.add(link7);
        links.add(link8);
        links.add(link9);
        links.add(link10);
        links.add(link11);
        links.add(link12);
        links.add(link13);
        links.add(link14);
        links.add(link15);
        links.add(link16);
        links.add(link17);
        hosting1.setLinks(links);
        
        Album album1 = albumService.searchByName("Highway to Hell");
        
        Song song1 = new Song("1", "Highway to Hell", album1, link1);
        Song song2 = new Song("2", "Girls Got Rhythm", album1, link2);
        Song song3 = new Song("3", "Walk All Over You", album1, link3);
        Song song4 = new Song("4", "Touch Too Much", album1, link4);
        Song song5 = new Song("5", "Beating Around The Bush", album1, link5);
        Song song6 = new Song("6", "Shot Down in Flames", album1, link6);
        Song song7 = new Song("7", "Get it Hot", album1, link7);
        Song song8 = new Song("8", "If You Want Blood (You ve Got It)", album1, link8);
        Song song9 = new Song("9", "Love Hungry Man", album1, link9);
        Song song10 = new Song("10", "Night Prowler", album1, link10);
        
        link1.setSong(song1);
        link2.setSong(song2);
        link3.setSong(song3);
        link4.setSong(song4);
        link5.setSong(song5);
        link6.setSong(song6);
        link7.setSong(song7);
        link8.setSong(song8);
        link9.setSong(song9);
        link10.setSong(song10);
        
        List<Song> album1Songs = new ArrayList<>();
        album1Songs.add(song1);
        album1Songs.add(song2);
        album1Songs.add(song3);
        album1Songs.add(song4);
        album1Songs.add(song5);
        album1Songs.add(song6);
        album1Songs.add(song7);
        album1Songs.add(song8);
        album1Songs.add(song9);
        album1Songs.add(song10);
        album1.setSongs(album1Songs);
        
        songService.save(song1);
        songService.save(song2);
        songService.save(song3);
        songService.save(song4);
        songService.save(song5);
        songService.save(song6);
        songService.save(song7);
        songService.save(song8);
        songService.save(song9);
        songService.save(song10);        
        
        Album album2 = albumService.searchByName("Presense");
        
        Song song11 = new Song("1", "Achilles Last Stand", album2, link11);
        Song song12 = new Song("2", "For Your Life", album2, link12);
        Song song13 = new Song("3", "Royal Orleans", album2, link13);
        Song song14 = new Song("4", "Nobodys Fault But Mine", album2, link14);
        Song song15 = new Song("5", "Candy Store Rock", album2, link15);
        Song song16 = new Song("6", "Hots On For Nowhere", album2, link16);
        Song song17 = new Song("7", "Tea For One", album2, link17);
        
        link11.setSong(song11);
        link12.setSong(song12);
        link13.setSong(song13);
        link14.setSong(song14);
        link15.setSong(song15);
        link16.setSong(song16);
        link17.setSong(song17);       

        List<Song> album2Songs = new ArrayList<>();
        album2Songs.add(song11);
        album2Songs.add(song12);
        album2Songs.add(song13);
        album2Songs.add(song14);
        album2Songs.add(song15);
        album2Songs.add(song16);
        album2Songs.add(song17);
        album2.setSongs(album2Songs);

        songService.save(song11);
        songService.save(song12);
        songService.save(song13);
        songService.save(song14);
        songService.save(song15);
        songService.save(song16);
        songService.save(song17);
    }
}
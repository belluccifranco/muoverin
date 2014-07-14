package com.vinilo.util;

import com.vinilo.model.Album;
import com.vinilo.model.Artist;
import com.vinilo.model.HostingAccount;
import com.vinilo.model.Link;
import com.vinilo.model.Song;
import com.vinilo.model.UserAccount;
import com.vinilo.model.UserRole;
import com.vinilo.service.AccountService;
import com.vinilo.service.SongService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class DataPopulator implements InitializingBean {

    @Autowired
    private SongService songService;

    @Autowired
    private AccountService accountService;

    private void loadUsers() {
        //USER ROLES
        UserRole roleCustomer = new UserRole("ROLE_CUSTOMER");
        UserRole roleAdmin = new UserRole("ROLE_ADMIN");

        //USER ACCOUNTS
        List<UserRole> customerRoles = new ArrayList<>();
        customerRoles.add(roleCustomer);
        UserAccount userFacundo = new UserAccount("facundo@vinilo.com", "e10adc3949ba59abbe56e057f20f883e", customerRoles);
        UserAccount userFranco = new UserAccount("franco@vinilo.com", "e10adc3949ba59abbe56e057f20f883e", customerRoles);
        List<UserRole> adminRoles = new ArrayList<>();
        adminRoles.add(roleAdmin);
        UserAccount userAdmin = new UserAccount("admin@vinilo.com", "e10adc3949ba59abbe56e057f20f883e", adminRoles);

        List<UserAccount> customerAccounts = new ArrayList<>();
        customerAccounts.add(userFacundo);
        customerAccounts.add(userFranco);
        roleCustomer.setUserAccounts(customerAccounts);

        List<UserAccount> adminAccounts = new ArrayList<>();
        adminAccounts.add(userAdmin);
        roleAdmin.setUserAccounts(adminAccounts);

        accountService.save(userFacundo);
        accountService.save(userFranco);
        accountService.save(userAdmin);
    }

    private void loadSongs() {
        //HOSTING ACCOUNTS
        HostingAccount ha1 = new HostingAccount("https://g.api.mega.co.nz", "cuentavinilo01@gmail.com", "Ninguna01");

        //LINKS
        Link l1 = new Link("https://mega.co.nz/#!ilhghR7D!bXAvBGk_Z-7nFWZeHr0meC5Ce_4yFqHF38AnVmO7gew", ha1);
        Link l2 = new Link("https://mega.co.nz/#!ipQ1HabR!eFikkFla4rIOqPpCJVgxlCSNaRoQGCadYk17qgBrFFY", ha1);
        Link l3 = new Link("https://mega.co.nz/#!u05HDKSC!DauTn0lUVaUOjauoxXXqpk5Y4qYi3wVCA46XLZbontk", ha1);
        Link l4 = new Link("https://mega.co.nz/#!yhATDbxL!Ujkb-jqdxc_r5RxNOVls-0Upik15bIiPp_W36hI6uO4", ha1);
        Link l5 = new Link("https://mega.co.nz/#!DhRw1IjJ!aA30wnfpF7Z97DRRnZrSRHq51VpWoVI1UCj45YH-j4w", ha1);
        Link l6 = new Link("https://mega.co.nz/#!n8AzSLSb!XJOUBCWK9K6Tux9W6JM_GGTswUQVuutzo2Fb8L2TGpw", ha1);
        Link l7 = new Link("https://mega.co.nz/#!HshkSBrL!LbhwQz1kgPTSA8i-85rGmBVdEUwJwFIh-isoa7-JYW8", ha1);
        Link l8 = new Link("https://mega.co.nz/#!esYkBQbQ!FdxakAVWP6A5sHWb4DOCj01i31UPkyMKV0by9Pb6Hps", ha1);
        Link l9 = new Link("https://mega.co.nz/#!XghGjAYB!HMKf-Vt3hB9WICSa0Tak7Xxywo5TsX2FF8NMI8mo7Dk", ha1);
        Link l10 = new Link("https://mega.co.nz/#!Tw4B0ZjL!WThKG0EqXIvrLeyzWVMT6ia_m1pec3NA18yeTnyBD1A", ha1);
        Link l11 = new Link("https://mega.co.nz/#!OkxT2CQQ!VNGQzxRoTqbVLSGhnrTxjVVX_C1NHHJhjHgDwtzeUx0", ha1);
        Link l12 = new Link("https://mega.co.nz/#!Osw2WTwD!fl6NTE1LbX7yq20hoLW9d1naZKt3g6ta6O_oucXNVTg", ha1);
        Link l13 = new Link("https://mega.co.nz/#!20gSAAqa!ZwJG4QRJKJ75GLiueYfATivpz_laKt2Z2LMWQX2esH8", ha1);
        Link l14 = new Link("https://mega.co.nz/#!v8wCXSIb!fdgHRHilmQW1olzTxZkiLlwkMsIyGZyKz3SwSpOnC8Q", ha1);
        Link l15 = new Link("https://mega.co.nz/#!614k1BSQ!GzwglVZX0lO99bnl5IQcRArpwCVTYMnn7GERSJgNCyI", ha1);
        Link l16 = new Link("https://mega.co.nz/#!TtpwiYIT!X9dvM0nA5XBI4nOlObLBOW_vKK52WsFJFG34WT6sSDY", ha1);
        Link l17 = new Link("https://mega.co.nz/#!e95BlaID!aHdUkANGbgrHpi8eXk_gMUytaDMttmb3o52gwHLiXHU", ha1);

        List<Link> links = new ArrayList<>();
        links.add(l1);
        links.add(l2);
        links.add(l3);
        links.add(l4);
        links.add(l5);
        links.add(l6);
        links.add(l7);
        links.add(l8);
        links.add(l9);
        links.add(l10);
        links.add(l11);
        links.add(l12);
        links.add(l13);
        links.add(l14);
        links.add(l15);
        links.add(l16);
        links.add(l17);
        ha1.setLinks(links);

        //ARTISTS
        Artist acdc = new Artist("AC DC");
        List<Artist> artistsHighwayToHell = new ArrayList<>();
        artistsHighwayToHell.add(acdc);
        Artist ledzeppelin = new Artist("Led Zeppelin");
        List<Artist> artistsPresence = new ArrayList<>();
        artistsPresence.add(ledzeppelin);

        //ALBUM
        List<Album> acdcAlbumes = new ArrayList<>();
        Album highwayToHell = new Album("Highway to Hell", 1979, 10);
        acdcAlbumes.add(highwayToHell);
        List<Album> ledZepplinAlbumes = new ArrayList<>();
        Album presense = new Album("Presense", 1976, 7);
        ledZepplinAlbumes.add(presense);

        acdc.setAlbums(acdcAlbumes);
        ledzeppelin.setAlbums(ledZepplinAlbumes);

        highwayToHell.setArtists(artistsHighwayToHell);
        presense.setArtists(artistsPresence);

        //SONGS
        Song song1 = new Song(1, "Highway to Hell", "", highwayToHell, l1);
        Song song2 = new Song(2, "Girls Got Rhythm", "", highwayToHell, l2);
        Song song3 = new Song(3, "Walk All Over You", "", highwayToHell, l3);
        Song song4 = new Song(4, "Touch Too Much", "", highwayToHell, l4);
        Song song5 = new Song(5, "Beating Around The Bush", "", highwayToHell, l5);
        Song song6 = new Song(6, "Shot Down in Flames", "", highwayToHell, l6);
        Song song7 = new Song(7, "Get it Hot", "", highwayToHell, l7);
        Song song8 = new Song(8, "If You Want Blood (You ve Got It)", "", highwayToHell, l8);
        Song song9 = new Song(9, "Love Hungry Man", "", highwayToHell, l9);
        Song song10 = new Song(10, "Night Prowler", "", highwayToHell, l10);

        Song song11 = new Song(1, "Achilles Last Stand", "", presense, l11);
        Song song12 = new Song(2, "For Your Life", "", presense, l12);
        Song song13 = new Song(3, "Royal Orleans", "", presense, l13);
        Song song14 = new Song(4, "Nobodys Fault But Mine", "", presense, l14);
        Song song15 = new Song(5, "Candy Store Rock", "", presense, l15);
        Song song16 = new Song(6, "Hots On For Nowhere", "", presense, l16);
        Song song17 = new Song(7, "Tea For One", "", presense, l17);

        l1.setSong(song1);
        l2.setSong(song2);
        l3.setSong(song3);
        l4.setSong(song4);
        l5.setSong(song5);
        l6.setSong(song6);
        l7.setSong(song7);
        l8.setSong(song8);
        l9.setSong(song9);
        l10.setSong(song10);
        l11.setSong(song11);
        l12.setSong(song12);
        l13.setSong(song13);
        l14.setSong(song14);
        l15.setSong(song15);
        l16.setSong(song16);
        l17.setSong(song17);       

        List<Song> highwayToHellSongs = new ArrayList<>();
        highwayToHellSongs.add(song1);
        highwayToHellSongs.add(song2);
        highwayToHellSongs.add(song3);
        highwayToHellSongs.add(song4);
        highwayToHellSongs.add(song5);
        highwayToHellSongs.add(song6);
        highwayToHellSongs.add(song7);
        highwayToHellSongs.add(song8);
        highwayToHellSongs.add(song9);
        highwayToHellSongs.add(song10);
        highwayToHell.setSongs(highwayToHellSongs);        

        List<Song> presenseSongs = new ArrayList<>();
        presenseSongs.add(song11);
        presenseSongs.add(song12);
        presenseSongs.add(song13);
        presenseSongs.add(song14);
        presenseSongs.add(song15);
        presenseSongs.add(song16);
        presenseSongs.add(song17);
        presense.setSongs(presenseSongs);        

        songService.save(song1);
        songService.save(song11);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.loadUsers();
        this.loadSongs();
    }
}

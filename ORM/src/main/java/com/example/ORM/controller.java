package com.example.ORM;

import com.example.ORM.Entity.TicketTable;
import com.example.ORM.Entity.BusTable;
import com.example.ORM.Repo.JimeRepo;
import com.example.ORM.Repo.JusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;

@RestController
public class controller {
    @Autowired
    private JusRepo jusRepo;
    @Autowired
    private JimeRepo jimeRepo;
//    @GetMapping("new")
//    public BusTable nww(){
//        BusTable jus = new BusTable();
//        TicketTable jime = new TicketTable();
//        Time time = new Time(8,45,00);
//        jime.setTime(time);
//        jimeRepo.save(jime);
//        jus.setFirstName("eka");
//        jus.setSecondName("mbaram");
//        jus.setTime(jime);
//        jusRepo.save(jus);
//        return jus;
//    }
}

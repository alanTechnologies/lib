package com.lib.system.Student;

import org.mapstruct.factory.Mappers;

public class EclerService {

    EclerMapper eclerMapper = Mappers.getMapper(EclerMapper.class);

    public void tryMapStruct(){
        Ecler ecler = new Ecler();
        ecler.setName("Ciprian");
        ecler.setCnp(23);
        ecler.setMarime(100);

        EclerDTO eclerDTO = eclerMapper.toStudentDTO(ecler);
        System.out.println(eclerDTO);

    }
}

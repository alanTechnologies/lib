package com.lib.system.Student;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EclerMapper {

    EclerDTO toStudentDTO(Ecler ecler);

}

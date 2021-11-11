package com.lib.system.mappers;

import com.lib.system.DTO.BookDTO;
import com.lib.system.entity.Book;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BookDTOMapper {

    BookDTO toBookDto(Book book );

}

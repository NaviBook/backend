package KNU.Navibook.server.dto;

import KNU.Navibook.server.domain.Record;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordDTO {
    List<Record> recordDto;
    private Integer count;
}

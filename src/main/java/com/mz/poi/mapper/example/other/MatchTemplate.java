package com.mz.poi.mapper.example.other;

import com.mz.poi.mapper.annotation.Cell;
import com.mz.poi.mapper.annotation.CellStyle;
import com.mz.poi.mapper.annotation.DataRows;
import com.mz.poi.mapper.annotation.Excel;
import com.mz.poi.mapper.annotation.Font;
import com.mz.poi.mapper.annotation.Header;
import com.mz.poi.mapper.annotation.Match;
import com.mz.poi.mapper.annotation.Row;
import com.mz.poi.mapper.annotation.Sheet;
import com.mz.poi.mapper.structure.CellType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Excel(
    defaultStyle = @CellStyle(
        font = @Font(fontName = "Arial")
    )
)
public class MatchTemplate {

    private TestSheet sheet = new TestSheet();

    @Builder
    public MatchTemplate(TestSheet sheet) {
        this.sheet = sheet;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Sheet(
            name = "Test",
            index = 0
    )
    public static class TestSheet {

        private List<MatchTestDataRow> matchTestTable;

        private MatchTestRow matchTestRow = new MatchTestRow();

        @Builder
        public TestSheet(
            List<MatchTestDataRow> matchTestTable) {
            this.matchTestTable = matchTestTable;
        }
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @DataRows(
            row = 0,
            match = Match.STOP_ON_BLANK,
            headers = {
                    @Header(name = "a", mappings = {"firstValue"}),
                    @Header(name = "b", mappings = {"secondValue"})
            }
    )
    public static class MatchTestDataRow {

        @Cell(
            column = 0,
            cellType = CellType.STRING
        )
        private String firstValue;

        @Cell(
            column = 1,
            cellType = CellType.NUMERIC
        )
        private Integer secondValue;

        @Builder
        public MatchTestDataRow(String firstValue, Integer secondValue) {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Row(
            rowAfter = "matchTestTable",
            rowAfterOffset = 1
    )
    public static class MatchTestRow {

        @Cell(
            column = 0,
            cellType = CellType.STRING
        )
        private String value = "sample";
    }
}

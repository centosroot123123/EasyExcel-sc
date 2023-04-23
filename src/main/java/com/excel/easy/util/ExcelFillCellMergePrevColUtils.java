package com.excel.easy.util;

import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//列合并工具类
public class ExcelFillCellMergePrevColUtils implements CellWriteHandler {
    private static final String KEY ="%s-%s";
    //所有的合并信息都存在了这个map里面
    Map<String, Integer> mergeInfo = new HashMap<>();

    public ExcelFillCellMergePrevColUtils() {
    }

    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer integer, Integer integer1, Boolean aBoolean) {

    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer integer, Boolean aBoolean) {

    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<WriteCellData<?>> list, Cell cell, Head head, Integer integer, Boolean aBoolean) {
        //当前行
        int curRowIndex = cell.getRowIndex();
        //当前列
        int curColIndex = cell.getColumnIndex();

        Integer num = mergeInfo.get(String.format(KEY, curRowIndex, curColIndex));
        if(null != num){
            // 合并最后一行 ,列
            mergeWithPrevCol(writeSheetHolder, cell, curRowIndex, curColIndex,num);
        }
    }
    public void mergeWithPrevCol(WriteSheetHolder writeSheetHolder, Cell cell, int curRowIndex, int curColIndex, int num) {
        Sheet sheet = writeSheetHolder.getSheet();
        CellRangeAddress cellRangeAddress = new CellRangeAddress(curRowIndex, curRowIndex, curColIndex, curColIndex + num);
        sheet.addMergedRegion(cellRangeAddress);
    }
    //num从第几列开始增加多少列,(6,2,7)代表的意思就是第6行的第2列至第2+7也就是9列开始合并
    public void add (int curRowIndex,  int curColIndex , int num){
        mergeInfo.put(String.format(KEY, curRowIndex, curColIndex),num);
    }

}

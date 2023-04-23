package com.excel.easy.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.data.ImageData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.FileUtils;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.excel.easy.db.entity.*;
import com.excel.easy.db.service.*;
import com.excel.easy.pojo.dto.*;
import com.excel.easy.pojo.vo.AutoExport;
import com.excel.easy.pojo.vo.AutoExportInfoVo;
import com.excel.easy.pojo.vo.AutoExportLogVo;
import com.excel.easy.util.ExcelFillCellMergePrevColUtils;
import com.excel.easy.util.MyDateUtil;
import com.excel.easy.util.Result;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExcelService {

    private final NsjWorkerInfoService workerInfoService;
    private final NsjSubstationInfoService substationInfoService;
    private final NsjCompanyInfoService companyInfoService;
    private final NsjSchemeInfoService schemeInfoService;
    private final NsjSchemeCountersignLogService logService;
    private final NsjSchemeCountersignInfoService schemeCountersignInfoService;

    public ExcelService(NsjWorkerInfoService workerInfoService, NsjSubstationInfoService substationInfoService, NsjSchemeCountersignInfoService schemeCountersignInfoService,
                        NsjCompanyInfoService companyInfoService,
                        NsjSchemeInfoService schemeInfoService,
                        NsjSchemeCountersignLogService logService) {
        this.substationInfoService = substationInfoService;
        this.schemeCountersignInfoService = schemeCountersignInfoService;
        this.logService = logService;
        this.schemeInfoService = schemeInfoService;
        this.companyInfoService = companyInfoService;
        this.workerInfoService = workerInfoService;
    }

    public void excelImg(InputStream resourceAsStream, OnlineUpdateWorkRecordDto dto) throws IOException {

        List<KeySecurityMonitoringPointsForTomorrowDto> ksmpftDto = dto.getKsmpftDto();
        List<ResultsDto> resultsDto = dto.getResultsDto();
        List<WorkCompletedTodayDto> wctDtos = dto.getWctDtos();
        List<MechanicalConfigurationTodayDto> mctDtos = dto.getMctDtos();
        List<WorkCompletedTodayDto> tpcWctDtos = dto.getTpcWctDtos();
        List<MechanicalConfigurationTodayDto> tpcMctDtos = dto.getTpcMctDtos();
        List<TodayMainQualityChecksDto> tmqcDtos = dto.getTmqcDtos();
        List<MainQualityDto> mqDtos = dto.getMqDtos();
        List<MonitoringPointsDto> mpDtos = dto.getMpDtos();
        List<ListDto> mainIssues = dto.getMainIssues();
        List<ConstructionPhotosDtos> constructionPhotos = new ArrayList<>();
        List<ProjectProgressMilestonesDto> ppmDtos = dto.getPpmDtos();

        List<String> photos = dto.getConstructionPhotoList();
        ConstructionPhotosDtos constructionPhotosDtos = new ConstructionPhotosDtos();
        if (!CollectionUtils.isEmpty(photos)) {
            for (int i = 0; i < photos.size(); i++) {
                String url = photos.get(i);
                WriteCellData<Void> writeCellData = new WriteCellData<>();
                // 这里可以设置为 EMPTY 则代表不需要其他数据了
                writeCellData.setType(null);
                List<ImageData> imageDataList = new ArrayList<>();

                ImageData imageData = new ImageData();
                imageData.setTop(5);
                imageData.setBottom(5);
                imageData.setLeft(5);
                imageData.setRelativeFirstRowIndex(2);//这一行使导出的excel部分内容有问题，功能正常，但影响体验
                imageData.setImageType(ImageData.ImageType.PICTURE_TYPE_PNG);
                imageData.setImage(FileUtils.readFileToByteArray(new File(url)));
                if (i % 2 == 1) {
                    imageData.setRelativeLastColumnIndex(3);
                    imageDataList.add(imageData);
                    writeCellData.setImageDataList(imageDataList);
                    constructionPhotosDtos.setImg2(writeCellData);
                } else {
                    imageDataList.add(imageData);
                    imageData.setRelativeLastColumnIndex(4);
                    writeCellData.setImageDataList(imageDataList);
                    constructionPhotosDtos.setImg1(writeCellData);
                }
                if (constructionPhotosDtos.getImg2() != null || i == photos.size() - 1) {
                    constructionPhotos.add(constructionPhotosDtos);
                    if (i == photos.size() - 1) {
                        continue;
                    }
                    constructionPhotosDtos = new ConstructionPhotosDtos();
                }
            }
        }

        ExcelFillCellMergePrevColUtils excelFillCellMergePrevColUtils =
                getExcelFill(ksmpftDto, resultsDto, wctDtos, mctDtos, tpcWctDtos,
                        tpcMctDtos, tmqcDtos, mqDtos, mpDtos, mainIssues, ppmDtos);

        //需要填充的数据
        String pathName = "D:/" + IdWorker.getId() + ".xlsx";//IdWorker.getId():雪花随机数
        ExcelWriterBuilder builder = EasyExcel.write(pathName);
        builder.registerWriteHandler(excelFillCellMergePrevColUtils);

        ExcelWriter excelWriter = builder.withTemplate(resourceAsStream).build();
        //创建sheet
        WriteSheet writeSheet = EasyExcel.writerSheet(0).build();
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();

        excelWriter.fill(new FillWrapper("resultsDto", resultsDto), fillConfig, writeSheet);
        excelWriter.fill(new FillWrapper("ksmpftDto", ksmpftDto), fillConfig, writeSheet);
        excelWriter.fill(new FillWrapper("wctDtos", wctDtos), fillConfig, writeSheet);
        excelWriter.fill(new FillWrapper("mctDtos", mctDtos), fillConfig, writeSheet);
        excelWriter.fill(new FillWrapper("tpcWctDtos", tpcWctDtos), fillConfig, writeSheet);
        excelWriter.fill(new FillWrapper("tpcMctDtos", tpcMctDtos), fillConfig, writeSheet);
        excelWriter.fill(new FillWrapper("tmqcDtos", tmqcDtos), fillConfig, writeSheet);
        excelWriter.fill(new FillWrapper("mqDtos", mqDtos), fillConfig, writeSheet);
        excelWriter.fill(new FillWrapper("mpDtos", mpDtos), fillConfig, writeSheet);
        excelWriter.fill(new FillWrapper("mainIssues", mainIssues), fillConfig, writeSheet);
        excelWriter.fill(new FillWrapper("constructionPhotos", constructionPhotos), fillConfig, writeSheet);
        excelWriter.fill(new FillWrapper("ppmDtos", ppmDtos), fillConfig, writeSheet);
        excelWriter.fill(dto, writeSheet);

        //填充完成
        excelWriter.finish();
    }

    /**
     * 合并单元格策略
     */
    private static ExcelFillCellMergePrevColUtils getExcelFill(List<KeySecurityMonitoringPointsForTomorrowDto> ksmpftDto, List<ResultsDto> resultsDto, List<WorkCompletedTodayDto> wctDtos, List<MechanicalConfigurationTodayDto> mctDtos, List<WorkCompletedTodayDto> tpcWctDtos, List<MechanicalConfigurationTodayDto> tpcMctDtos, List<TodayMainQualityChecksDto> tmqcDtos, List<MainQualityDto> mqDtos, List<MonitoringPointsDto> mpDtos, List<ListDto> mainIssues, List<ProjectProgressMilestonesDto> ppmDtos) {

        ExcelFillCellMergePrevColUtils excelFillCellMergePrevColUtils = new ExcelFillCellMergePrevColUtils();
        int i0 = 11;
        if (!CollectionUtils.isEmpty(ppmDtos)) {
            for (int i = 0; i < ppmDtos.size(); i++) {
                i0 = i0 + i;
                excelFillCellMergePrevColUtils.add(i0, 2, 2);
            }
        }

        int i1 = i0 + 30;
        if (!CollectionUtils.isEmpty(resultsDto)) {
            for (int i = 0; i < resultsDto.size(); i++) {//合并对主要安全问题的措施、结果
                i1 = i1 + i;
                excelFillCellMergePrevColUtils.add(i1, 0, 3);
                excelFillCellMergePrevColUtils.add(i1, 4, 2);
                excelFillCellMergePrevColUtils.add(i1, 7, 1);
            }
        }

        int i2 = i1 + 3;
        if (!CollectionUtils.isEmpty(ksmpftDto)) {
            for (int i = 0; i < ksmpftDto.size(); i++) {//合并明日主要安全监控要点
                i2 = i2 + i;
                excelFillCellMergePrevColUtils.add(i2, 0, 1);
                excelFillCellMergePrevColUtils.add(i2, 2, 4);
                excelFillCellMergePrevColUtils.add(i2, 7, 1);
            }
        }


        int i3 = i2 + 11;
        if (!CollectionUtils.isEmpty(wctDtos)) {
            for (int i = 0; i < wctDtos.size(); i++) {//合并今日工作完成情况
                i3 = i3 + i;//上面有多少行
                excelFillCellMergePrevColUtils.add(
                        i3, 1, 1);
                excelFillCellMergePrevColUtils.add(
                        i3, 3, 1);
                excelFillCellMergePrevColUtils.add(
                        i3, 5, 1);
                excelFillCellMergePrevColUtils.add(
                        i3, 7, 1);
            }
        }

        int i4 = i3 + 4;
        //合并今日劳动力配置
        excelFillCellMergePrevColUtils.add(i4, 2, 1);
        excelFillCellMergePrevColUtils.add(i4, 4, 1);
        excelFillCellMergePrevColUtils.add(i4, 7, 1);

        int i5 = i4 + 2;
        if (!CollectionUtils.isEmpty(mctDtos)) {
            for (int i = 0; i < mctDtos.size(); i++) {//合并今日机械配置情况
                i5 = i5 + i;
                excelFillCellMergePrevColUtils.add(i5, 1, 1);
                excelFillCellMergePrevColUtils.add(i5, 4, 1);
                excelFillCellMergePrevColUtils.add(i5, 6, 2);
            }
        }

        int i6 = i5 + 4;
        if (!CollectionUtils.isEmpty(tpcWctDtos)) {
            for (int i = 0; i < tpcWctDtos.size(); i++) {//合并明日工作计划
                i6 = i6 + i;
                excelFillCellMergePrevColUtils.add(i6, 1, 1);
                excelFillCellMergePrevColUtils.add(i6, 3, 1);
                excelFillCellMergePrevColUtils.add(i6, 5, 1);
                excelFillCellMergePrevColUtils.add(i6, 7, 1);
            }
        }

        //合并明日劳动力配置计划
        int i7 = i6 + 4;
        excelFillCellMergePrevColUtils.add(i7, 2, 1);
        excelFillCellMergePrevColUtils.add(i7, 4, 1);
        excelFillCellMergePrevColUtils.add(i7, 7, 1);

        int i8 = i7 + 2;//上面有多少行
        if (!CollectionUtils.isEmpty(tpcMctDtos)) {
            for (int i = 0; i < tpcMctDtos.size(); i++) {//合并明日机械、设备配置计划
                i8 = i8 + i;
                excelFillCellMergePrevColUtils.add(i8, 1, 1);
                excelFillCellMergePrevColUtils.add(i8, 4, 1);
                excelFillCellMergePrevColUtils.add(i8, 6, 2);
            }
        }

        int i9 = i8 + 4;//上面有多少行
        if (!CollectionUtils.isEmpty(tmqcDtos)) {
            for (int i = 0; i < tmqcDtos.size(); i++) {//合并今日主要质量检查情况
                i9 = i9 + i;
                excelFillCellMergePrevColUtils.add(i9, 0, 2);
                excelFillCellMergePrevColUtils.add(i9, 3, 5);
            }
        }


        int i10 = i9 + 3;//上面有多少行
        if (!CollectionUtils.isEmpty(mqDtos)) {
            for (int i = 0; i < mqDtos.size(); i++) {//合并对主要质量、技术问题的处理措施、处理结果
                i10 = i10 + i;
                excelFillCellMergePrevColUtils.add(i10, 1, 1);
                excelFillCellMergePrevColUtils.add(i10, 3, 2);
                excelFillCellMergePrevColUtils.add(i10, 6, 2);
            }
        }

        int i11 = i10 + 3;//上面有多少行
        if (!CollectionUtils.isEmpty(mpDtos)) {
            for (int i = 0; i < mpDtos.size(); i++) {//合并明日主要质量监控要点
                i11 = i11 + i;
                excelFillCellMergePrevColUtils.add(i11, 0, 2);
                excelFillCellMergePrevColUtils.add(i11, 3, 2);
                excelFillCellMergePrevColUtils.add(i11, 6, 2);
            }
        }


        int i12 = i11 + 2;//上面有多少行
        if (!CollectionUtils.isEmpty(mainIssues)) {
            for (int i = 0; i < mainIssues.size(); i++) {//合并存在的主要问题和需协调事项
                i12 = i12 + i;
                excelFillCellMergePrevColUtils.add(i12, 0, 8);
            }
        }
        return excelFillCellMergePrevColUtils;
    }

    public void excel(InputStream resourceAsStream, String fileName, List<AutoExportLogVo> data,
                      List<AutoExportInfoVo> infos, AutoExport exportExcelBase/*, HttpServletResponse response*/) {

        //ServletOutputStream out = response.getOutputStream();
        //BufferedOutputStream bos = new BufferedOutputStream(out);
        //设置文件类型
        //response.setContentType("application/vnd.ms-excel");
        //设置编码格式
        //response.setCharacterEncoding("utf-8");
        //response.setHeader("Content-disposition", "attachment;filename=" +
        //URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
        //创建excel,下面一行filePath换成bos，就是返回流给浏览器进行下载

        ExcelFillCellMergePrevColUtils excelFillCellMergePrevColUtils = new ExcelFillCellMergePrevColUtils();

        for (int i = 0; i < data.size(); i++) {
            excelFillCellMergePrevColUtils.add(7+i, 0, 1);//合并审批人
            excelFillCellMergePrevColUtils.add(7+i, 2, 2);//合并审批人单位
            excelFillCellMergePrevColUtils.add(7+i, 5, 4);//合并审批时间
            excelFillCellMergePrevColUtils.add(7+i, 10, 1);//合并审批意见
        }

        for (int i = 0; i < infos.size(); i++) {//合并打印签章
            excelFillCellMergePrevColUtils.add(8+data.size()+i, 1, 11);
        }

        String filePath = "D:/" + fileName + ".xlsx";
        ExcelWriterBuilder builder = EasyExcel.write(filePath);
        builder.registerWriteHandler(excelFillCellMergePrevColUtils);

        ExcelWriter excelWriter = builder.withTemplate(resourceAsStream).build();
        //创建sheet
        WriteSheet writeSheet = EasyExcel.writerSheet(0).build();
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();

        excelWriter.fill(new FillWrapper("log", data), fillConfig, writeSheet);
        excelWriter.fill(new FillWrapper("info", infos), fillConfig, writeSheet);
        excelWriter.fill(exportExcelBase, writeSheet);

        //填充完成
        excelWriter.finish();

        //设置请求头
        /*HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("multipart/form-data");
        headers.setContentType(type);
        //设置请求体，注意是LinkedMultiValueMap
        FileSystemResource fileSystemResource = new FileSystemResource(filePath);
        MultiValueMap form = new LinkedMultiValueMap<>();
        form.add("file", fileSystemResource);
        //用HttpEntity封装整个请求报文

        HttpEntity files = new HttpEntity<>(form, headers);
        String url = "http://192.168.1.127:9331/an2000/common/upload";
        Map<String, Map<String, Object>> map = restTemplate.postForObject(url, files, Map.class);
        String signature = map.get("resultData").get("id").toString();
        NsjSchemeInfo nsjSchemeInfo = new NsjSchemeInfo();
        nsjSchemeInfo.setId(fileName);
        nsjSchemeInfo.setSignature(signature);
        schemeInfoService.updateById(nsjSchemeInfo);*/
        //bos.flush();
//        FileSystemUtils.deleteRecursively(new File(filePath));//上传文件后删除本地文件
    }

    public Result countersign(CountersignDTO dto, String userId) {
        String id = dto.getId();//方案id
        NsjSchemeCountersignInfo nsjSchemeCountersignInfo = new NsjSchemeCountersignInfo();
        nsjSchemeCountersignInfo.setResult(dto.getResult());
        nsjSchemeCountersignInfo.setRemark(dto.getRemark());
        nsjSchemeCountersignInfo.setUpdateTime(new Date());

        boolean update = schemeCountersignInfoService.update(nsjSchemeCountersignInfo,
                new LambdaQueryWrapper<NsjSchemeCountersignInfo>().
                        eq(NsjSchemeCountersignInfo::getSchemeId, id).
                        eq(NsjSchemeCountersignInfo::getSignatory, userId));
        if (update) {
            NsjSchemeCountersignLog log = new NsjSchemeCountersignLog();
            log.setSchemeId(id);
            log.setSignatory(userId);
            log.setLogTime(new Date());
            log.setRemark(dto.getRemark());
            log.setResult(dto.getResult());
            logService.save(log);
            List<NsjSchemeCountersignInfo> list = schemeCountersignInfoService.list(new LambdaQueryWrapper<NsjSchemeCountersignInfo>().
                    eq(NsjSchemeCountersignInfo::getSchemeId, id));
            IntSummaryStatistics summaryStatistics = list.stream().mapToInt((s) -> s.getResult() == null ? 1 : s.getResult()).summaryStatistics();
            long sum = summaryStatistics.getSum();//会签之和=0说明全部会签完成
            if (sum == 0) {
                InputStream resourceAsStream = this.getClass().getClassLoader().
                        getResourceAsStream("template/资料审核会签单样式.xlsx");
                excel(resourceAsStream, id, getAutoExportLogVos(id), getSignatorys(id), getAutoExport(id));
            }
            return Result.succ("审批成功！");
        } else {
            return Result.succ("审批失败！");
        }
    }

    public List<AutoExportInfoVo> getSignatorys(String id) {
        Map<String, String> workerDic = getWorkerDic();
        List<NsjSchemeCountersignInfo> list = schemeCountersignInfoService.list(new LambdaQueryWrapper<NsjSchemeCountersignInfo>().eq(NsjSchemeCountersignInfo::getSchemeId, id));
        return list.stream().map(w -> new AutoExportInfoVo(workerDic.get(w.getSignatory()),"")).collect(Collectors.toList());
    }

    public Map<String, String> getWorkerDic() {
        List<NsjWorkerInfo> list = workerInfoService.list();
        return list.stream().collect(
                Collectors.toMap(NsjWorkerInfo::getId, NsjWorkerInfo::getName));
    }

    public AutoExport getAutoExport(String id) {
        Map<String, String> companyDic = getCompanyDic();
        Map<String, String> stDic = getStDic();
        NsjSchemeInfo s = schemeInfoService.getById(id);
        String createUser = s.getCreateUser();
        Map<String, NsjWorkerInfo> workerMap = getWorkerMap();
        NsjWorkerInfo workerInfo = workerMap.get(createUser);
        return new AutoExport(id, s.getName(), companyDic.get(workerInfo.getCompany()),
                workerInfo.getPhone(), stDic.get(workerInfo.getStId()), workerInfo.getName(),
                MyDateUtil.date2String(s.getCreateTime(), null),
                s.getContent());
    }

    public Map<String, NsjWorkerInfo> getWorkerMap() {//人员id-entity组成的Map
        List<NsjWorkerInfo> list = workerInfoService.list();
        return list.stream().collect(Collectors.toMap(
                NsjWorkerInfo::getId, each -> each, (value1, value2) -> value1));
    }

    public Map<String, String> getStDic() {//场站id-name组成的字典
        List<NsjSubstationInfo> list = substationInfoService.list();
        return list.stream().collect(Collectors.toMap(NsjSubstationInfo::getId, NsjSubstationInfo::getName));
    }

    public List<AutoExportLogVo> getAutoExportLogVos(String id) {//获取会签日志

        LambdaQueryWrapper<NsjSchemeCountersignLog> eq = new LambdaQueryWrapper<NsjSchemeCountersignLog>().
                eq(NsjSchemeCountersignLog::getSchemeId, id);
        List<NsjSchemeCountersignLog> list = logService.list(
                eq);

        int count = logService.count(eq.eq(NsjSchemeCountersignLog::getResult, 1));
        Map<String, String> companyDic = getCompanyDic();
        Map<String, NsjWorkerInfo> workerMap = getWorkerMap();
        return list.stream().map(
                w -> new AutoExportLogVo(workerMap.get(w.getSignatory()).getName(),
                        companyDic.get(workerMap.get(w.getSignatory()).getCompany()),
                        MyDateUtil.date2String(w.getLogTime(), null),
                        w.getRemark(), count == 1 ? "是" : "否")).collect(Collectors.toList());
    }

    private Map<String, String> getCompanyDic() {
        List<NsjCompanyInfo> companyInfos = companyInfoService.list();
        return companyInfos.stream().collect(
                Collectors.toMap(NsjCompanyInfo::getId, NsjCompanyInfo::getName));
    }

}

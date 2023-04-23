package com.excel.easy.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class OnlineUpdateWorkRecordDto {//pdf
    private String stName;//场站名称
    private String fileDate;//日期
    private String weather;//天气
    //一、工程概况
    private List<ProjectProgressMilestonesDto> ppmDtos;//工程进度里程碑
    private String currentProgress;//当前进度

    //二、施工安全
    private String content;//二.1
    // 今日安全文明及环境控制情况
    private String ppmDtoContent;
    private String ppmDtoDate;
    private List<ResultsDto> resultsDto;//对主要安全问题的措施、结果
    private List<KeySecurityMonitoringPointsForTomorrowDto> ksmpftDto;//明日主要安全监控要点
    //三、施工计划进度及现场项目管理情况
    //总的情况
    private List<String> overall;//设计//物资进度//土建进度//电气安装和调试
    //今天的计划和完成情况
    private List<WorkCompletedTodayDto> wctDtos;//今日工作完成情况
    //今日劳动力配置
    private String numberOfManagers;//管理人员人数
    private String numberOfFrontlineWrkers;//一线工人数
    private String numberOfCommissioners;//调试人数
    private String numberOfEquipmentManufacturers;//设备厂商人数
    private String total;//合计
    private String remark;//备注
    private List<MechanicalConfigurationTodayDto> mctDtos;//今日机械配置情况
    //明日计划
    private List<WorkCompletedTodayDto> tpcWctDtos;//明日工作计划
    //明日劳动力配置
    private String tpcWatNumberOfManagers;//管理人员人数
    private String tpcWatNumberOfFrontlineWrkers;//一线工人数
    private String tpcWatNumberOfCommissioners;//调试人数
    private String tpcWatNumberOfEquipmentManuFacturers;//设备厂商人数
    private Integer tpcWatTotal;//合计
    private String tpcWatRemark;//备注
    private List<MechanicalConfigurationTodayDto> tpcMctDtos;//明日机械配置情况
    //四、工程质量
    private List<TodayMainQualityChecksDto> tmqcDtos;//1.今日主要质量检查情况
    private List<MainQualityDto> mqDtos;//2. 对主要质量、技术问题的处理措施、处理结果
    private List<MonitoringPointsDto> mpDtos;//3. 明日主要质量监控要点
    //五、存在的主要问题和需协调事项
    private List<ListDto> mainIssues;
    //六、施工照片
    @JsonIgnore
    private List<ConstructionPhotosDtos> constructionPhotos;
    private List<String> constructionPhotoList;

    public OnlineUpdateWorkRecordDto() {
    }

    public OnlineUpdateWorkRecordDto(String stName, String fileDate, String weather,
                                     List<ProjectProgressMilestonesDto> ppmDtos, String currentProgress,
                                     String content, String ppmDtoContent, String ppmDtoDate,
                                     List<ResultsDto> resultsDto,
                                     List<KeySecurityMonitoringPointsForTomorrowDto> ksmpftDto,
                                     List<String> overall, List<WorkCompletedTodayDto> wctDtos,
                                     String numberOfManagers, String numberOfFrontlineWrkers,
                                     String numberOfCommissioners, String numberOfEquipmentManufacturers,
                                     String total, String remark,
                                     List<MechanicalConfigurationTodayDto> mctDtos,
                                     List<WorkCompletedTodayDto> tpcWctDtos,
                                     String tpcWatNumberOfManagers,
                                     String tpcWatNumberOfFrontlineWrkers,
                                     String tpcWatNumberOfCommissioners,
                                     String tpcWatNumberOfEquipmentManuFacturers,
                                     Integer tpcWatTotal, String tpcWatRemark,
                                     List<MechanicalConfigurationTodayDto> tpcMctDtos,
                                     List<TodayMainQualityChecksDto> tmqcDtos,
                                     List<MainQualityDto> mqDtos, List<MonitoringPointsDto> mpDtos,
                                     List<ListDto> mainIssues,
                                     List<String> constructionPhotoList) {
        this.stName = stName;
        this.fileDate = fileDate;
        this.weather = weather;
        this.ppmDtos = ppmDtos;
        this.currentProgress = currentProgress;
        this.content = content;
        this.ppmDtoContent = ppmDtoContent;
        this.ppmDtoDate = ppmDtoDate;
        this.resultsDto = resultsDto;
        this.ksmpftDto = ksmpftDto;
        this.wctDtos = wctDtos;
        this.numberOfManagers = numberOfManagers;
        this.numberOfFrontlineWrkers = numberOfFrontlineWrkers;
        this.numberOfCommissioners = numberOfCommissioners;
        this.numberOfEquipmentManufacturers = numberOfEquipmentManufacturers;
        this.total = total;
        this.overall = overall;
        this.remark = remark;
        this.mctDtos = mctDtos;
        this.tpcWctDtos = tpcWctDtos;
        this.tpcWatNumberOfManagers = tpcWatNumberOfManagers;
        this.tpcWatNumberOfFrontlineWrkers = tpcWatNumberOfFrontlineWrkers;
        this.tpcWatNumberOfCommissioners = tpcWatNumberOfCommissioners;
        this.tpcWatNumberOfEquipmentManuFacturers = tpcWatNumberOfEquipmentManuFacturers;
        this.tpcWatTotal = tpcWatTotal;
        this.tpcWatRemark = tpcWatRemark;
        this.tpcMctDtos = tpcMctDtos;
        this.tmqcDtos = tmqcDtos;
        this.mqDtos = mqDtos;
        this.mpDtos = mpDtos;
        this.mainIssues = mainIssues;
        this.constructionPhotoList = constructionPhotoList;
    }

    public List<String> getConstructionPhotoList() {
        return constructionPhotoList;
    }

    public void setConstructionPhotoList(List<String> constructionPhotoList) {
        this.constructionPhotoList = constructionPhotoList;
    }

    public String getTpcWatNumberOfManagers() {
        return tpcWatNumberOfManagers;
    }

    public void setTpcWatNumberOfManagers(String tpcWatNumberOfManagers) {
        this.tpcWatNumberOfManagers = tpcWatNumberOfManagers;
    }

    public String getTpcWatNumberOfFrontlineWrkers() {
        return tpcWatNumberOfFrontlineWrkers;
    }

    public void setTpcWatNumberOfFrontlineWrkers(String tpcWatNumberOfFrontlineWrkers) {
        this.tpcWatNumberOfFrontlineWrkers = tpcWatNumberOfFrontlineWrkers;
    }

    public String getTpcWatNumberOfCommissioners() {
        return tpcWatNumberOfCommissioners;
    }

    public void setTpcWatNumberOfCommissioners(String tpcWatNumberOfCommissioners) {
        this.tpcWatNumberOfCommissioners = tpcWatNumberOfCommissioners;
    }

    public String getTpcWatNumberOfEquipmentManuFacturers() {
        return tpcWatNumberOfEquipmentManuFacturers;
    }

    public void setTpcWatNumberOfEquipmentManuFacturers(String tpcWatNumberOfEquipmentManuFacturers) {
        this.tpcWatNumberOfEquipmentManuFacturers = tpcWatNumberOfEquipmentManuFacturers;
    }

    public Integer getTpcWatTotal() {
        return tpcWatTotal;
    }

    public void setTpcWatTotal(Integer tpcWatTotal) {
        this.tpcWatTotal = tpcWatTotal;
    }

    public String getTpcWatRemark() {
        return tpcWatRemark;
    }

    public void setTpcWatRemark(String tpcWatRemark) {
        this.tpcWatRemark = tpcWatRemark;
    }

    public List<WorkCompletedTodayDto> getTpcWctDtos() {
        return tpcWctDtos;
    }

    public void setTpcWctDtos(List<WorkCompletedTodayDto> tpcWctDtos) {
        this.tpcWctDtos = tpcWctDtos;
    }

    public List<MechanicalConfigurationTodayDto> getTpcMctDtos() {
        return tpcMctDtos;
    }

    public void setTpcMctDtos(List<MechanicalConfigurationTodayDto> tpcMctDtos) {
        this.tpcMctDtos = tpcMctDtos;
    }

    public List<String> getOverall() {
        return overall;
    }

    public void setOverall(List<String> overall) {
        this.overall = overall;
    }

    public String getPpmDtoContent() {
        return ppmDtoContent;
    }

    public void setPpmDtoContent(String ppmDtoContent) {
        this.ppmDtoContent = ppmDtoContent;
    }

    public String getPpmDtoDate() {
        return ppmDtoDate;
    }

    public void setPpmDtoDate(String ppmDtoDate) {
        this.ppmDtoDate = ppmDtoDate;
    }

    public List<ProjectProgressMilestonesDto> getPpmDtos() {
        return ppmDtos;
    }

    public void setPpmDtos(List<ProjectProgressMilestonesDto> ppmDtos) {
        this.ppmDtos = ppmDtos;
    }

    public String getCurrentProgress() {
        return currentProgress;
    }

    public void setCurrentProgress(String currentProgress) {
        this.currentProgress = currentProgress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ResultsDto> getResultsDto() {
        return resultsDto;
    }

    public void setResultsDto(List<ResultsDto> resultsDto) {
        this.resultsDto = resultsDto;
    }

    public List<KeySecurityMonitoringPointsForTomorrowDto> getKsmpftDto() {
        return ksmpftDto;
    }

    public void setKsmpftDto(List<KeySecurityMonitoringPointsForTomorrowDto> ksmpftDto) {
        this.ksmpftDto = ksmpftDto;
    }

    public List<WorkCompletedTodayDto> getWctDtos() {
        return wctDtos;
    }

    public void setWctDtos(List<WorkCompletedTodayDto> wctDtos) {
        this.wctDtos = wctDtos;
    }

    public String getNumberOfManagers() {
        return numberOfManagers;
    }

    public void setNumberOfManagers(String numberOfManagers) {
        this.numberOfManagers = numberOfManagers;
    }

    public String getNumberOfFrontlineWrkers() {
        return numberOfFrontlineWrkers;
    }

    public void setNumberOfFrontlineWrkers(String numberOfFrontlineWrkers) {
        this.numberOfFrontlineWrkers = numberOfFrontlineWrkers;
    }

    public String getNumberOfCommissioners() {
        return numberOfCommissioners;
    }

    public void setNumberOfCommissioners(String numberOfCommissioners) {
        this.numberOfCommissioners = numberOfCommissioners;
    }

    public String getNumberOfEquipmentManufacturers() {
        return numberOfEquipmentManufacturers;
    }

    public void setNumberOfEquipmentManufacturers(String numberOfEquipmentManufacturers) {
        this.numberOfEquipmentManufacturers = numberOfEquipmentManufacturers;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<MechanicalConfigurationTodayDto> getMctDtos() {
        return mctDtos;
    }

    public void setMctDtos(List<MechanicalConfigurationTodayDto> mctDtos) {
        this.mctDtos = mctDtos;
    }

    public List<TodayMainQualityChecksDto> getTmqcDtos() {
        return tmqcDtos;
    }

    public void setTmqcDtos(List<TodayMainQualityChecksDto> tmqcDtos) {
        this.tmqcDtos = tmqcDtos;
    }

    public List<MainQualityDto> getMqDtos() {
        return mqDtos;
    }

    public void setMqDtos(List<MainQualityDto> mqDtos) {
        this.mqDtos = mqDtos;
    }

    public List<MonitoringPointsDto> getMpDtos() {
        return mpDtos;
    }

    public void setMpDtos(List<MonitoringPointsDto> mpDtos) {
        this.mpDtos = mpDtos;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public List<ListDto> getMainIssues() {
        return mainIssues;
    }

    public void setMainIssues(List<ListDto> mainIssues) {
        this.mainIssues = mainIssues;
    }

    public List<ConstructionPhotosDtos> getConstructionPhotos() {
        return constructionPhotos;
    }

    public void setConstructionPhotos(List<ConstructionPhotosDtos> constructionPhotos) {
        this.constructionPhotos = constructionPhotos;
    }
}

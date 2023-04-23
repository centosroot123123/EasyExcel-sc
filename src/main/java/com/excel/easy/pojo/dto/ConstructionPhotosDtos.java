package com.excel.easy.pojo.dto;

import com.alibaba.excel.metadata.data.WriteCellData;

public class ConstructionPhotosDtos {
    private WriteCellData<Void> img1;
    private WriteCellData<Void> img2;

    public ConstructionPhotosDtos() {
    }

    public ConstructionPhotosDtos(WriteCellData<Void> img1, WriteCellData<Void> img2) {
        this.img1 = img1;
        this.img2 = img2;
    }

    public WriteCellData<Void> getImg1() {
        return img1;
    }

    public void setImg1(WriteCellData<Void> img1) {
        this.img1 = img1;
    }

    public WriteCellData<Void> getImg2() {
        return img2;
    }

    public void setImg2(WriteCellData<Void> img2) {
        this.img2 = img2;
    }
}

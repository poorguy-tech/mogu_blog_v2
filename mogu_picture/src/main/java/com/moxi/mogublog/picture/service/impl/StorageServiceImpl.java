package com.moxi.mogublog.picture.service.impl;


import com.moxi.mogublog.picture.entity.File;
import com.moxi.mogublog.picture.entity.NetworkDisk;
import com.moxi.mogublog.picture.entity.Storage;
import com.moxi.mogublog.picture.global.SysConf;
import com.moxi.mogublog.picture.mapper.StorageMapper;
import com.moxi.mogublog.picture.service.NetworkDiskService;
import com.moxi.mogublog.picture.service.StorageService;
import com.moxi.mogublog.utils.upload.UploadFile;
import com.moxi.mogublog.utils.upload.Uploader;
import com.moxi.mougblog.base.serviceImpl.SuperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 文件服务实现类
 * </p>
 *
 * @author xuzhixiang
 * @since 2018-09-17
 */
@Slf4j
@Service
public class StorageServiceImpl extends SuperServiceImpl<StorageMapper, Storage> implements StorageService {

    @Autowired
    NetworkDiskService networkDiskService;

    @Override
    public void uploadFile(HttpServletRequest request, NetworkDisk networkDisk, List<File> fileList) {
        List<NetworkDisk> networkDiskList = new ArrayList<>();
        for (int i = 0; i < fileList.size(); i++){
            File file = fileList.get(i);
                NetworkDisk saveNetworkDisk = new NetworkDisk();
                saveNetworkDisk.setAdminUid(SysConf.DEFAULT_UID);
                saveNetworkDisk.setFilePath(networkDisk.getFilePath());
                saveNetworkDisk.setFileUrl(file.getPicUrl());
                saveNetworkDisk.setFileSize(file.getFileSize());
                saveNetworkDisk.setFileName(file.getPicName());
                saveNetworkDisk.setExtendName(file.getPicExpandedName());
                saveNetworkDisk.setTimestampName("");
                saveNetworkDisk.setCreateTime(new Date());
                networkDiskList.add(saveNetworkDisk);
        }
        networkDiskService.saveBatch(networkDiskList);
    }

    @Override
    public Storage selectStorageBean(Storage storageBean) {
        return null;
    }

    @Override
    public void insertStorageBean(Storage storageBean) {

    }

    @Override
    public void updateStorageBean(Storage storageBean) {

    }

    @Override
    public Storage selectStorageByUser(Storage storageBean) {
        return null;
    }
}
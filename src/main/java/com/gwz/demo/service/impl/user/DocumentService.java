package com.gwz.demo.service.impl.user;

import com.gwz.demo.model.UpFile;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

public class DocumentService {
    public static final DocumentService documentService=new DocumentService();
    static UpFile filedao=UpFile.filedao;
    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    public Page<UpFile> paginate(int pageNumber,int pageSize){
        Page<UpFile> filepage=  filedao.paginate(pageNumber,pageSize,"select *","from file");
        return filepage;
    }
    public boolean deleteDocById(String id){
        return filedao.deleteById(id);
    }
    public UpFile findById(String id){
        return filedao.findById(id);
    }
    public UpFile finByChecksum(String checksum){
        return filedao.findFirst("select * from file where checksum=?",checksum);
    }

}

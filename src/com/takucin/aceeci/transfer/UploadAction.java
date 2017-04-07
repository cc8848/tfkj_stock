package com.takucin.aceeci.transfer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;

import com.takucin.aceeci.exception.NullContentTypeException;
import com.takucin.aceeci.exception.UploadAdapterInitException;
import com.takucin.aceeci.frame.CommonAction;
import com.takucin.aceeci.util.Common;

public abstract class UploadAction extends CommonAction {

	private UploadAdapter uploadAdapter;

	public static final String CONTENT_TYPE_XLS = "application/vnd.ms-excel";

	/**
	 * 上传方法.
	 */
	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (uploadAdapter == null) {
			throw new UploadAdapterInitException();
		}
		TransferEvent event = new TransferEvent(mapping, form, request, response);
		FormFile file = uploadAdapter.getFormFile(event);
		String[] contentTypes = uploadAdapter.getLegalContentTypes(event);
		if (contentTypes == null || contentTypes.length == 0) {
			throw new NullContentTypeException();
		}
		for (int i = 0; i < contentTypes.length; i++) {
			if (file.getContentType().equals(CONTENT_TYPE_XLS)) {
				break;
			}
			if (i == (contentTypes.length - 1)) {
				ActionMessages messages = new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						uploadAdapter.getIllegalContentTypeError(event)));
				saveMessages(request, messages);
				return mapping.findForward(uploadAdapter.getUploadErrorForward(event));
			}
		}
		if(file.getFileSize() > uploadAdapter.getMaxSize(event)){
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					uploadAdapter.getIllegalFileSizeError(event)));
			saveMessages(request, messages);
			return mapping.findForward(uploadAdapter.getUploadErrorForward(event));
		}
		InputStream input = file.getInputStream();
		String path = uploadAdapter.getFileTargetPath(event);
		POIFSFileSystem poifsFileSystem = new POIFSFileSystem(input);
		HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
		deleteFile(path);
		OutputStream output = new FileOutputStream(path);
		wb.write(output);
		output.flush();
		output.close();
		String error = uploadAdapter.parseFile(event);
		if(!Common.isNull(error)){
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(error));
			saveMessages(request, messages);
			return mapping.findForward(uploadAdapter.getUploadForward(event));
		}
		return mapping.findForward(uploadAdapter.getUploadForward(event));
	}
	
	private void deleteFile(String path) throws Exception{
		File file = new File(path);
		if(file.exists()){
			file.delete();
		}
	}

	public UploadAdapter getUploadAdapter() {
		return uploadAdapter;
	}

	public void setUploadAdapter(UploadAdapter uploadAdapter) {
		this.uploadAdapter = uploadAdapter;
	}

}

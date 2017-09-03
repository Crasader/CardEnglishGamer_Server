package org.kteam.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Administrator on 2017/8/20 0020.
 */
@Controller
public class download {
    /**
     * 文件下载
     * @Description:
     * @param fileName
     * @param request
     * @param response
     * @return
     */
    @Value("#{configProperties['EXTERNAL_FILE_PATH']}")
    private  String EXTERNAL_FILE_PATH;

    @RequestMapping("/download")
    public String downloadFile(@RequestParam(value = "fileName",required = false) String fileName,
                               HttpServletRequest request, HttpServletResponse response) {
        System.out.println(EXTERNAL_FILE_PATH);
        if (fileName != null) {
//            String realPath = request.getServletContext().getRealPath(
//                    "WEB-INF/File/");
//            File file = new File(realPath, fileName);

            File file = new File(EXTERNAL_FILE_PATH);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}

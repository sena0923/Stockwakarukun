package scoremanager.ECsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        if (name == null || name.isEmpty()) {
            return;
        }

        // images フォルダの実体パスを取得
        String imagePath = getServletContext().getRealPath("/images/" + name);
        File file = new File(imagePath);

        // 画像が存在しない場合は noimage.png
        if (!file.exists()) {
            file = new File(getServletContext().getRealPath("/images/noimage.png"));
        }

        res.setContentType("image/png");

        try (
            FileInputStream in = new FileInputStream(file);
            OutputStream out = res.getOutputStream();
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        }
    }
}

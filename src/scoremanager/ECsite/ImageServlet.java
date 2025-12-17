package scoremanager.ECsite;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException {

        try {
            String name = req.getParameter("name");

            // 画像の実体（例：WebContent外でもOK）
            String imagePath = getServletContext()
                    .getRealPath("/WEB-INF/images/" + name);

            File file = new File(imagePath);

            // 無い場合は noimage
            if (!file.exists()) {
                imagePath = getServletContext()
                        .getRealPath("/WEB-INF/images/noimage.png");
                file = new File(imagePath);
            }

            resp.setContentType("image/png");

            FileInputStream fis = new FileInputStream(file);
            OutputStream os = resp.getOutputStream();

            byte[] buf = new byte[1024];
            int len;
            while ((len = fis.read(buf)) != -1) {
                os.write(buf, 0, len);
            }

            fis.close();
            os.close();

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

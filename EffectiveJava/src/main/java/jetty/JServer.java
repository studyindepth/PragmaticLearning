package jetty;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.BlockingArrayQueue;

public class JServer {
    public static void main(String[] args) throws Exception {
        BlockingQueue<Runnable> taskQueue = new BlockingArrayQueue<>(600);
        Server server = new Server(9988);

        server.setAttribute("org.eclipse.jetty.server.Request.maxFormContentSize", 1);
        server.setHandler(new AbstractHandler() {
            @Override
            public void handle(String target, Request baseRequest, HttpServletRequest request,
                    HttpServletResponse response) throws IOException, ServletException {
                String s = "xxx";
                s = request.getParameter("name");
                System.out.println(s);
            }
        });
        server.start();
    }
}

package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServer {
    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);

    public static void main(String[] args) throws Exception {
        String webappDirLocation = "webapps/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        log.info("configuring app with basedir: {}", new File("./" + webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
// 빌드 프로그램을 인텔리제이로 변경한 후 프로젝트 세팅의 모듈에서 main과 test를 아래의 주소로 변경
// 그 후 main을 실행하면 webapps밑에 애플리케이션 서버가 빌드가 된다
// ∵ Tomcat이 해당 클래스를 실행할 수 있기 때문(Tomcat은 root directory밑의 WEB-INF밑의 classes밑에서 자바 클래스를 찾기 때문)
// C:\Users\SONG\IdeaProjects\mvc-practice\webapps\WEB-INF\classes
// C:\Users\SONG\IdeaProjects\mvc-practice\webapps\WEB-INF\test\classes

// http://www.kbn.re.kr/docs/appdev/deployment.html의 Standard Directory Layout 참고

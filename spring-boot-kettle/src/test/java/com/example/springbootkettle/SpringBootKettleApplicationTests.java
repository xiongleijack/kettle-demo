package com.example.springbootkettle;

import org.junit.jupiter.api.Test;
import org.pentaho.di.core.KettleClientEnvironment;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootKettleApplicationTests {

    private String filename = "D:\\学习资料\\kettlestudy\\spring-boot.ktr";

    @Test
    public void testEtl() {
        try {
            KettleEnvironment.init();
            TransMeta transMeta = new TransMeta(filename);
            Trans trans = new Trans(transMeta);

            String beginTime = "2019-04-02 00:00:00";
            String endTime = "2019-04-06 23:59:59";

            trans.setVariable("beginTime", beginTime);
            trans.setVariable("endTime", endTime);
            trans.execute(null);
            trans.waitUntilFinished();
        } catch (KettleException e) {
            e.printStackTrace();
        }

    }

}

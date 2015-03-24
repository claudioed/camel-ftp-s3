package com.claudioliveira.aws.s3;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.aws.s3.S3Constants;
import org.springframework.stereotype.Component;

/**
 * Created by claudio on 10/03/15.
 */
@Component
public class TranferFileFtpToS3Router extends RouteBuilder {

    private static final String FTP_CONFIGURATION = "ftp://MEU ENDERECO FTP";

    private static final String S3_CONFIGURATION = "aws-s3://MEU BUCKET?amazonS3Client=#s3Client&region=REGIAO DO BUCKET";

    @Override
    public void configure() throws Exception {
        from(FTP_CONFIGURATION).routeId("").setHeader(S3Constants.KEY, header("CamelFileNameConsumed"))
                .to(S3_CONFIGURATION).log("Upload Complete: ${in.body.fileName}");
    }
    
}

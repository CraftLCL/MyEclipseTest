package Util;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by lcl on 2017/3/5.
 */
public class XmlWrite {
    public static void writeGoodXml(Document document){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("good.xml");
            OutputFormat outputFormat =new OutputFormat();
            outputFormat.setEncoding("utf-8");
            XMLWriter xmlWrite=new XMLWriter(fileOutputStream,outputFormat);
            xmlWrite.write(document);
            xmlWrite.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

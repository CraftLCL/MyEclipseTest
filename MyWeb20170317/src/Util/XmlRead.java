package Util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * Created by lcl on 2017/3/5.
 */
public class XmlRead {
    public static Document readGoodXml(){
        SAXReader saxReader=new SAXReader();
        Document document=null;
        try {
            document=saxReader.read(new File("good.xml"));

        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return document;
    }
}

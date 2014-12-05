package cn.net.lisong.jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class Test {

	public static void main(String[] args) {
		String string = "/home/lisong/KuaiPan/Dropbox/ref/shell/www.freeos.com/guides/lsst/aboutthisdoc.html";
		File input = new File(string);
		
		try {
			Document doc = Jsoup.parse(input, "UTF-8", "");
//			OutputSettings out = doc.outputSettings();
//			boolean pp = out.prettyPrint();
//			System.out.println(pp);
			Elements ss = doc.getElementsByTag("script");
			for (int i = 0; i < ss.size(); i++) {
				Element e = ss.get(i);
				e.remove();
			}
			removeComments(doc);
//			System.out.println(doc.tagName());
//			System.out.println(doc.dataNodes());
			
			System.out.println(doc.html());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void removeComments(Node node) {
        for (int i = 0; i < node.childNodes().size();) {
            Node child = node.childNode(i);
            if (child.nodeName().equals("#comment"))
                child.remove();
            else {
                removeComments(child);
                i++;
            }
        }
    }       
}

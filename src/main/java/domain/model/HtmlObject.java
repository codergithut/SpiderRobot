package domain.model;

import util.FormatHtmlUtil;
import util.HttpClientUtil;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/11/2
 * @description
 */
public class HtmlObject {

    private String url;

    private String origincontent;

    private String content;

    private List<String> css;

    private List<String> js;

    private Set<String> linked;

    private String root;

    private String title;

    private String summary;



    public HtmlObject(String url) throws IOException {
        this.url = url;
        System.out.println(url);
        origincontent = HttpClientUtil.getConnect(url, null, null);
        if(origincontent != null) {
            content = FormatHtmlUtil.removeHtmlTag(origincontent).replaceAll("\n{2,}", "");
            css = FormatHtmlUtil.getCSS(origincontent);
            title = FormatHtmlUtil.getTitle(origincontent);
            root = FormatHtmlUtil.getTopDomain(url);
            linked = FormatHtmlUtil.getLink(origincontent, root);
            js = FormatHtmlUtil.getScript(origincontent);
            //AbstractEntrance abstractEntrance = new AbstractEntrance();
            //summary = abstractEntrance.getAbstractByContent(content, 100);
        }
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getJs() {
        return js;
    }

    public void setJs(List<String> js) {
        this.js = js;
    }

    public Set<String> getLinked() {
        return linked;
    }

    public void setLinked(Set<String> linked) {
        this.linked = linked;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getOrigincontent() {
        return origincontent;
    }

    public void setOrigincontent(String origincontent) {
        this.origincontent = origincontent;
    }


}

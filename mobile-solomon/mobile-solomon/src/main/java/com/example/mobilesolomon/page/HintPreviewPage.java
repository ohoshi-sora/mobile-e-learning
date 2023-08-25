package com.example.mobilesolomon.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicketstuff.annotation.mount.MountPath;

// 生成したヒントを見ることができ、ヒントを修正するのか、確定するのかを選択できる

@MountPath("HintPreview")
public class HintPreviewPage extends WebPage {

    public HintPreviewPage() {
        var toHintMakerLink = new BookmarkablePageLink<>("toHintMaker", HintMakerPage.class);
        add(toHintMakerLink);
        var toHintMakeCompLink = new BookmarkablePageLink<>("toHintMakeComp", HintMakeCompPage.class);
        add(toHintMakeCompLink);
        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);

    }

}

package com.example.mobilesolomon.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicketstuff.annotation.mount.MountPath;


// ヒントを作るページ
@MountPath("HintMaker")
public class HintMakerPage extends WebPage {

    public HintMakerPage() {
        var toHintPreview = new BookmarkablePageLink<>("toHintPreview", HintPreviewPage.class);
        add(toHintPreview);
        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);
    }

}

// WebPage間を移動する 01 WebPageクラスのサブクラスを作成までやった

package com.example.mobilesolomon.presentation;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicketstuff.annotation.mount.MountPath;
import org.apache.wicket.markup.html.WebPage;

@MountPath("HintMakeComp")
public class HintMakeCompPage extends WebPage {

    public HintMakeCompPage() {
        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);
    }

}

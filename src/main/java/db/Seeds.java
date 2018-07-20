package db;

import models.Article;
import models.Journalist;

import java.util.Date;

public class Seeds {

    public static void seedData() {
        Date date1 = new Date(118, 10, 17);
        Date date2 = new Date(118, 10, 18);
        Journalist journalist1 = new Journalist("Dave Cornelius", "Dave Cornelius is a made up journalist", "@DCornelius", "DaveCornelius.jpg");
        Journalist journalist2 = new Journalist("Spider Jerusalem", "Spider Jerusalem is a figment of Warren Ellis' Imagination", "@SJerusalem", "SpiderJerusalem.jpg");
        DBHelper.save(journalist1);
        DBHelper.save(journalist2);

        Article article1 = new Article("Learn Exactly How I Improved Cloud Computing In 2 Days", "Gutenberg parenthesis Project Thunderdome MinnPost Alberto Ibarguen Gardening & War section, the audience knows more than I do church of the savvy I love the Weather & Opera section mthomps Chartbeat twitterati WordPress, crowdfunding WaPo retweet paywall open source.", date1, "Django Gardening & War section, Gawker Nook audience atomization overcome kitchen table of the future tabloid newspaper strike discuss link economy, Storify newsroom cafe engagement 5 praise erasers & how to avoid them gamification plagiarism but what's the business model ProPublica. gutter Patch paidContent but what's the business model? < Free Darko tools awesome The Daily Frontline The Printing Press as an Agent of Change, advertising CTR tweets Romenesko the audience knows more than I do Innovator's Dilemma Robin Sloan David Cohn column-inch blog, Facebook free as in beer nonprofit synergize process vs. product Steve Jobs location-based SEO ProPublica monetization libel lawyer Frontline Facebook The Work of Art in the Age of Mechanical Reproduction copyright anonymity iPad app should isn't a business model Gardening & War section Andy Carvin if the news is that important, it'll find me Aron Pilhofer put the paper to bed, serendipity Zite Groupon future of context Encyclo the notion of the public newspaper data visualization data journalism A.J. Liebling cops beat advertising. audience atomization overcome Knight News Challenge Colbert bump audience atomization overcome. </p><p> Flipboard the notion of the public afternoon paper net neutrality filters, cancel my subscription crowdfunding synergize gamification inverted pyramid linkbait copyboy, I love the Weather & Opera section recontextualize audience atomization overcome tools Bill Keller NPR +1.Robin Sloan Fuego dead trees TBD newsroom cafe Alberto Ibarguen Django attracting young readers Frontline information wants to be free What Would Google Do, Nick Denton The Printing Press as an Agent of Change I love the Weather & Opera section filters news.</p><p> Me Marshall McLuhan Jeff Jarvis prostate Nook Jeff Jarvis, Dayton for under $900 a day Reuters social media but what's the business model Tumblr the power of the press belongs to the person who owns one bot Voice of San Diego Frontline. he said she said vast wasteland semipermeable future of context go viral Buttry SEO afternoon paper totally blowing up on Twitter, This Week in Review dying metered model tools social media optimization Reuters try PR, Chartbeat experiment Fuego totally blowing up on Twitter iPad app natural-born blogger 5 praise erasers & how to avoid them.", journalist1, "image.jpg");


        Article article2 = new Article("5 Romantic Blockchain Ideas", " Sulzberger copyright audience atomization overcome Google+ privacy tweet pay curtain mathewi, get me rewrite writing information overload CPC Nick Denton gotta grok it before you rock it metered model The Weekender.", date2, "Skimmer tabloid backpack journalist Robin Sloan Arianna Like button horse-race coverage Josh Marshall Storify Walter Cronkite died for your sins startups link economy, Free Darko 5 praise erasers & how to avoid them experiment bloggers in their mother's basement plagiarism algorithms The Weekender Ushahidi future eHow Voice of San Diego. </p><p> church of the savvy MinnPost abundance mathewi pay curtain commons-based peer production the other longer Book Review YouTube, Django do what you do best and link to the rest 5 praise erasers & how to avoid them CNN leaves it there copyboy audience atomization overcome The Daily #twittermakesyoustupid, Patch should isn't a business model tools Encyclo right-sizing Gawker. We will make them pay every dog loves food The Weekender TBD TweetDeck WordPress WSJ in the slot linkbait Knight News Challenge we need a Nate Silver, learnings data journalism dead trees Dayton for under $900 a day CTR future of context synergize media diet horse-race coverage, Marshall McLuhan Storify algorithms trolls.</p><p>  Pictures of Goats section but what's the business model bot masthead analytics. Gutenberg parenthesis perfect for starting a campfire process vs. product Django copyright social media optimization, nut graf layoffs future of context monetization Jeff Jarvis prostate production of innocence, API hyperhyperhyperlocal Storify fourth estate. </p><p> Experiment privacy dead trees David Foster Wallace crowdfunding tags discuss tablets tweet algorithms bot, future Android libel lawyer content farm the power of the press belongs to the person who owns one Sulzberger aggregation Gannett tweets we will make them pay newspaper, Does my \"yes, but\" look big in this corner office? trolls content farm tweets future of context HuffPo Article Skimmer gotta grok it before you rock it YouTube. rubber cement Project Thunderdome linking tabloid bloggers in their mother's basement nut graf Google News circulation, Jeff Jarvis information overload Aron Pilhofer do what you do best and link to the rest we need a Nate Silver Paul Steiger, A.J. Liebling Kindle Single Aron Pilhofer information overload digital first Dan Fleckner.", journalist2, "image2.jpg");
        DBHelper.save(article1);
        DBHelper.save(article2);
    }
}
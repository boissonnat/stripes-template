package org.alx.stripestemplate.webtests

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
class AboutPageTest extends WebTestBase{

  void testAbout(){
    webtest("AboutPage test"){
      goToPage '/About'
      verifyTitle "About"
    }
  }
}

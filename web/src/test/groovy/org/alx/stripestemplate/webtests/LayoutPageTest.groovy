package org.alx.stripestemplate.webtests

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
class LayoutPageTest extends WebTestBase{

    void testHome(){
        webtest("Layout test"){
            goToPage '/Home.htm'

            // Check master layout
            verifyXPath xpath:"/html/body/div[@id='header']"
            verifyXPath xpath:"/html/body/div[@id='navbar']"
            verifyXPath xpath:"/html/body/div[@id='main']"
            verifyXPath xpath:"/html/body/div[@id='footer']"

            // Check app title and slogan
            verifyXPath xpath:"/html/body/div[1]/h1", text:'MyApp !*', regex:true
            verifyXPath xpath:"/html/body/div[1]/h1/span", text:'The best slogan ever...'

            // Check navbar
            verifyXPath xpath:"/html/body/div[2]/ul/li[1]/a", text:'Home'
            verifyXPath xpath:"/html/body/div[2]/ul/li[2]/a", text:'About'

            // Check navbar
            verifyXPath xpath:"/html/body/div[4]", text:'This is your footer !'

        }
    }
}

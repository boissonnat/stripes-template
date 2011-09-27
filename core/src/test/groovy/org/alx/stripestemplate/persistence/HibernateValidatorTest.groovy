package org.alx.stripestemplate.persistence

import org.alx.stripestemplate.model.BaseTest
import org.junit.Test
import org.alx.stripestemplate.model.MyFakeObject

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
class HibernateValidatorTest extends BaseTest{

    @Test(expected = RuntimeException.class)
    void testNotNull(){
        doInTx {s->
            def b = new MyFakeObject()
            s.save(b)
        }
    }
}

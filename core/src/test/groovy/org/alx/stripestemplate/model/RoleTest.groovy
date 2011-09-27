package org.alx.stripestemplate.model

import org.alx.stripestemplate.BaseTest
import org.junit.Test

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
class RoleTest extends BaseTest {
    @Test
    void crud(){
        def id
        doInTx {s->
            // Create
            def g = new Role([name:'admin'])
            s.save(g)
            id = g.id
            assert id != null

            // Retrieve Role from DB
            g = s.load(Role.class, id)
            assert g != null
            assert g.name == 'admin'

            // Update
            g.name = 'users'
            s.save(g)
            g = s.load(Role.class, id)
            assert g != null
            assert g.id == id
            assert g.name == 'users'

            // Delete and failed to retrieve
            s.delete(g)
            g = s.load(Role.class, id)
            assert g == null
        }
    }

    @Test(expected = RuntimeException.class)
    void nameNotNull(){
        doInTx {s->
            def p = new Role()
            s.save(p)
        }
    }
}

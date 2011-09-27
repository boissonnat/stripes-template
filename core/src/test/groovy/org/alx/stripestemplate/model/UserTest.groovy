package org.alx.stripestemplate.model

import org.alx.stripestemplate.BaseTest
import org.junit.Test

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
class UserTest extends BaseTest {

    @Test
    void crud(){
        def id
        doInTx {s->
            // Create
            def u = new User([email:'foo@bar.com', password:'bar'])
            s.save(u)
            id = u.id
            assert id != null

            // Retrieve User from DB
            u = s.load(User.class, id)
            assert u != null
            assert u.email == 'foo@bar.com'

            // Update
            u.email = 'john@doe.com'
            s.save(u)
            u = s.load(User.class, id)
            assert u != null
            assert u.id == id
            assert u.email == 'john@doe.com'


            // Delete and failed to retrieve
            s.delete(u)
            u = s.load(User.class, id)
            assert u == null

        }
    }

    @Test(expected= RuntimeException)
    void nameAndPasswordCannotBeNull(){
        doInTx {s ->
            def u = new User()
            s.save(u)
        }
    }

    @Test(expected= RuntimeException)
    void emailCannotBeNull(){
        doInTx {s ->
            def u = new User([password:'bar'])
            s.save(u)
        }
    }

    @Test(expected= RuntimeException)
    void passwordCannotBeNull(){
        doInTx {s ->
            def u = new User([userName:'foo'])
            s.save(u)
        }
    }

    @Test(expected = RuntimeException)
    void emailFormatValidation(){
        doInTx {s->
            def u = new User([userName:'foo', password:'bar'])
            u.email = 'foobar'
            s.save(u)
        }
    }
}

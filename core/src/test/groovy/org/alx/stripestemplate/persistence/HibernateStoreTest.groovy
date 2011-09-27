package org.alx.stripestemplate.persistence

import org.alx.stripestemplate.model.BaseTest
import org.junit.Test
import org.alx.stripestemplate.util.MLogger
import org.alx.stripestemplate.model.MyFakeObject

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
class HibernateStoreTest extends BaseTest{

  private static final MLogger logger = MLogger.getLogger(HibernateStoreTest.class);

  /**
   * Here, we demonstrate that if an instance isn't retrieve in DB, the HibernateStore return a null object and not an Exception.<br/>
   * This is our implementation choice, we assume that the Hibernate exception have to be treat in the HibernateStore. It's your own role to manage the action
   * to do if the returned object is null.
   */
  @Test
  void testNoExistingReturnNull(){
    doInTx { s ->
      def e = s.load(MyFakeObject.class, 123)
      logger.info "e = $e"
      assert e == null
    }
  }

  /**
   * Hibernate could have really different behaviour in function of your transaction usage.<br/>
   * Here, we assure that you can add and delete an object in the same transaction.
   */
  @Test
  void testSaveAndLoadAndDeleteInSameTx() {
    doInTx { s ->
      def e = new MyFakeObject([name:"surf"])
      s.save(e)
      def id = e.id
      assert e != null

      e = s.load(MyFakeObject.class, id)
      assert e.name == "surf"
      s.delete(e)
      e = s.load(MyFakeObject.class, id)
      assert e == null
    }
  }

  /**
   * Hibernate could have really different behaviour in function of your transaction usage.<br/>
   * Here, we assure that you can add and delete an object in two different transactions and assert that to deletion has worked in a third transaction
   */
  @Test
  void testSaveAndLoadAndDeleteInDifferentTx() {
    def id
    doInTx { s ->
      def e = new MyFakeObject([name:"snow"])
      s.save(e)
      id = e.id
    }
    doInTx { s ->
      def e = s.load(MyFakeObject.class, id)
      assert e.name == "snow"
      s.delete(e)
    }
    doInTx { s ->
      def e = s.load(MyFakeObject.class, id)
      assert e == null
    }
  }


  /**
   * Hibernate store can return a list of object through the method load(Class clazz).<br/>
   * We are testing this method here.
   */
  @Test
  void testReturnListOfResult(){
    MyFakeObject mf1
    MyFakeObject mf2

    doInTx {s->
      // Create a set of building
      mf1 = new MyFakeObject([name:"snow"])
      mf2 = new MyFakeObject([name:"bike"])

      s.save(mf1)
      s.save(mf2)
    }

    doInTx {s->
      def buildings = s.load(Building.class)
      assert buildings instanceof List
      assert buildings != null
      assert buildings.contains(mf1)
      assert buildings.contains(mf2)
    }
  }
}
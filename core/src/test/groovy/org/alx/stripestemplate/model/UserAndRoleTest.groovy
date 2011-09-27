package org.alx.stripestemplate.model

import org.alx.stripestemplate.BaseTest
import org.junit.Test

/**
 * @author Alexis Boissonnat - alexis.boissonnat 'at' gmail.com
 */
class UserAndRoleTest extends BaseTest {

    @Test
    void normalRoundTrip(){
        def idAdminGroup
        def idRole
        def idAdmin
        def idUser

        Role userRole
        Role adminRole

        User admin
        User user

        doInTx {s->
            // Create Groups
            userRole = new Role([name:'userRole'])
            adminRole = new Role([name:'adminRole'])

            // Helper : create list with group
            Role[] userRoleList = [userRole]
            Role[] adminRoleList = [adminRole]
    //      Role[] userAndAdminGroupList = [userRole, adminRole]

            // Save the groups
            s.save(userRole)
            idRole = userRole.id
            s.save(adminRole)
            idAdminGroup = adminRole.id

            // Create some users with group
            admin = new User([email:'admin@admin.com', password:'admin', roles:userRoleList])
            user = new User([email:'user@user.com', password:'user', roles:adminRoleList])

            // Save users
            s.save(admin)
            idAdmin = admin.id
            s.save(user)
            idUser = user.id

            // Retrieve the Group list from the user
            def u = s.load(User.class, idUser)
            def a = s.load(User.class, idAdmin)
            assert u.roles != null
            assert a.roles != null
        }
        doInTx {s ->
            // Retrieve the users list from Group. We need to do this in another session (to avoid hibernate using the cache).
            def gA = s.load(Role.class, idAdminGroup)
            assert gA != null
            assert gA.users != null
        }

        doInTx {s->
            // Delete
            user = s.load(User.class, user.id)
            adminRole = s.load(Role, adminRole.id)
            assert user != null
            assert adminRole != null

            // Delete User 'user'
            s.delete(user)

            // Delete Role 'admin'
            s.delete(adminRole)
        }

        doInTx {s->
            // Assert deletion and delete rest of objects
            user = s.load(User.class, user.id)
            adminRole = s.load(Role, adminRole.id)
            assert user == null
            assert adminRole == null

            admin = s.load(User.class, admin.id)
            userRole = s.load(Role, userRole.id)
            assert admin != null
            assert userRole != null

            s.delete(admin)
            s.delete(userRole)
        }

    }

}

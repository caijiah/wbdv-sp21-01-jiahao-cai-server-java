(function () {
    var $usernameFld
    var $passwordFld
    var $firstNameFld
    var $lastNameFld
    var $roleFld
    var $updateBtn
    var $createBtn
    var $userRowTemplate
    var $tbody
    var userService = new AdminUserServiceClient();

    var allUsers = []

    function renderUsers(allUsers) {
        $tbody.empty()
        for (var i = 0; i < allUsers.length; i++) {
            var user = allUsers[i]
            $tbody.prepend(`
        <tr>
            <td>${user.username}</td>
            <td>&nbsp;</td>
            <td>${user.firstname}</td>
            <td>${user.lastname}</td>
            <td>${user.role}</td>
            <td class="wbdv-actions">
                <span class="pull-right">
                  <i class="fa-2x fa fa-times wbdv-remove-btn" id=${i}></i>
                  <i class="fa-2x fa fa-pencil wbdv-edit-btn" id=${user._id}></i>
                </span>
            </td>
        </tr>`)
        }
        $(".wbdv-remove-btn").click(deleteUser)
        $(".wbdv-edit-btn").click(selectUser)
    }

    function findAllUsers() {
        userService.findAllUsers()
            .then((actualAllUsers) => {
                console.log(actualAllUsers)
                allUsers = actualAllUsers
                renderUsers(allUsers)
            })
    }

    function createUser() {
        var user = {
            username: $usernameFld.val(),
            lastname: $lastNameFld.val(),
            firstname: $firstNameFld.val(),
            password: $passwordFld.val(),
            role: $roleFld.val()
        }
        console.log(user)
        userService.createUser(user)
            .then((actualUser) => {
                allUsers.unshift(actualUser)
                console.log(allUsers)
                renderUsers(allUsers)
            })
        $usernameFld.val("")
        $lastNameFld.val("")
        $firstNameFld.val("")
        $passwordFld.val("")
    }

    function deleteUser(event) {
        var deleteBtn = $(event.target)
        var theIndex = deleteBtn.attr("id")
        console.log(theIndex)
        console.log(allUsers)
        var theId = allUsers[theIndex]._id
        userService.deleteUser(theId)
            .then((status) => {
                allUsers.splice(theIndex, 1)
                renderUsers(allUsers)
            })
    }

    var selectedUser = null

    function selectUser(event) {
        var selectBtn = $(event.target)
        var theId = selectBtn.attr("id")
        selectedUser = allUsers.find(user => user._id === theId)
        $usernameFld.val(selectedUser.username)
        $firstNameFld.val(selectedUser.firstname)
        $lastNameFld.val(selectedUser.lastname)
        $passwordFld.val("")
        $roleFld.val(selectedUser.role)
    }

    function updateUser() {
        selectedUser.username = $usernameFld.val()
        selectedUser.firstname = $firstNameFld.val()
        selectedUser.lastname = $lastNameFld.val()
        selectedUser.role = $roleFld.val()
        selectedUser.password = $passwordFld.val()
        userService.updateUser(selectedUser._id, selectedUser)
            .then(function (status) {
                var index = allUsers.findIndex(user => user._id === selectedUser._id)
                allUsers[index] = selectedUser
                renderUsers(allUsers)
            })
        $usernameFld.val("")
        $lastNameFld.val("")
        $firstNameFld.val("")
        $passwordFld.val("")
    }

    function main() {
        $usernameFld = $(".wbdv-username-fld")
        $passwordFld = $(".wbdv-password-fld")
        $firstNameFld = $(".wbdv-firstname-fld")
        $lastNameFld = $(".wbdv-lastname-fld")
        $roleFld = $(".wbdv-role-fld")
        $createBtn = $(".wbdv-create-btn")
        $updateBtn = $(".wbdv-update-btn")
        $tbody = $(".wbdv-tbody")

        $createBtn.click(createUser)
        $updateBtn.click(updateUser)
        $usernameFld.val("")
        $passwordFld.val("")
        $firstNameFld.val("")
        $lastNameFld.val("")
        findAllUsers()
    }

    jQuery(main)
})();
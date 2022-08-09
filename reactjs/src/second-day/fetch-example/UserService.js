import axios from "axios";

const UserService = (function() {
  const _fetchUsers = async (params) => {
    const response = await axios.get("https://randomuser.me/api", {
      params: {
        results: params.pagination.pageSize,
        page: params.pagination.current,
        ...params
      }
    });

    if (!response) {
      console.log("Bir hata oluştu");
      //ToDo: Display error message to user not just log it
      //Ex: https://www.npmjs.com/package/react-toastify
      return;
    }

    return response.data;
  };

  return {
    fetchUsers: _fetchUsers
  };
})();

export default UserService;

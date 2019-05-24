import Axios from 'axios'


export function login(params){
    return Axios.post('http://120.78.74.165:8080/SSM/api/login',params).then(res=>res.data)
}

import { useParams, Navigate } from "react-router-dom"

type ChatParams={
    chatId:string
    
}
export function Chat(){
    const params =useParams


    if(!params.chatId){
        return <Navigate replace to='/'/>
    }
    return <div>Chat Criado {JSON.stringify(params)}</div>
}
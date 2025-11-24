import { QueryClient, QueryClientProvider, useQuery} from '@tanstack/react-query'
import { Link } from 'react-router-dom'
import { Chat } from './chat';
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from '@/components/ui/card';
import { ArrowRight } from 'lucide-react';
import { Badge } from '@/components/ui/badge';
import dayjs from 'dayjs';
export function CreateChat(){

    type GetChatsAPIResponse = Array<{id: string; name: string}>

    const queryClient= new QueryClient()
    const { data, isLoading}= useQuery({queryKey:['get-chat'], queryFn: 
        async()=>{ const response=await fetch('http://localhost:5173/chat')
        const data:GetChatsAPIResponse = await response.json()
        
        
        return data},
        })
    
        return(
        <div className='min-h-screen'>
            <div className='mx-auto px-4 max-w-4xl'>
                <div className='gap-8 grid cols-2 item-start'>

                <Card>
                    <CardHeader>
                        <CardTitle>
                            Chats recentes
                        </CardTitle>
                        <CardDescription>
                            Acesso rápido para os chats recentes
                        </CardDescription>
                    </CardHeader>
                    <CardContent className="flex flex-col gap-3">
                    {data?.map((chat)=>{
                        return (
                         <Link key={chat.id} className="flex item-center justify-between p-3 rounded-lg border hover: bg-accent" to={'/chat/${chat.id}'}>
                            <div className='flex-1'>
                                <h3 className='font-medium'>{Chat.name}</h3>

                                <div className='flex items-center gap-2'>
                                    <Badge variant={'secondary'}>
                                        {dayjs().toNow()}
                                        {chat.questionscount} pergunta(s)
                                    </Badge>
                                </div>
                            </div>

                            <span className='flex items-center gap-2 text-sm'>
                                Entrar
                                <ArrowRight className='size-3'/>
                            </span>

                        </Link>
                    )
                })}
                    </CardContent>
                </Card>
                <QueryClientProvider client={queryClient}>
                
                <div>Create Chat
                    <Link className="underline" to="/chat">Acessar Chat</Link>
                </div>
            <p>{isLoading && <h1>Carregando...</h1>}</p>
       
            <div>{data?.map((chat=>{
                return<Link key={chat.id}to='/chat/${chat.id}'>{Chat.name} </Link>
                 }))}
                </QueryClientProvider>
                </div>
            </div>
        </div>
        )
}


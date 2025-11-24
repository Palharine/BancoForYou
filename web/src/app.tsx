import { QueryClient, QueryClientProvider} from '@tanstack/react-query'
import { BrowserRouter, Route, Routes } from "react-router-dom"
import { CreateChat } from "./pages/create-chat"
import { Chat } from "./pages/chat"
export function App() {

  const queryClient= new QueryClient()

  return (
    <QueryClientProvider client={queryClient}>
  <BrowserRouter>
  <Route>
    <Routes index element={<CreateChat />} />
    <Route path="/chat:chatId" element={<Chat/>} />
  </Routes>
  </BrowserRouter>
  </QueryClientProvider>
  )
}



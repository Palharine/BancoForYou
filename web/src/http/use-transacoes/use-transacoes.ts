import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { api } from './api';
import type { TransacaoMinDTO, TransferenciaRequest } from './types/types';

export function useTransacoes() {
  return useQuery({
    queryKey: ['transacoes'],
    queryFn: async () => {
      const data = await api.get<TransacaoMinDTO[]>('/transacoes');
      return data;
    },
  });
}

export function useTransacoesByDate(data: string | null) {
  return useQuery({
    queryKey: ['transacoes', 'data', data],
    queryFn: async () => {
      if (!data) return [];
      const result = await api.get<TransacaoMinDTO[]>(`/transacoes?dataTransacao=${data}`);
      return result;
    },
    enabled: !!data,
  });
}

export function useTransacoesByReceptante(nome: string | null) {
  return useQuery({
    queryKey: ['transacoes', 'receptante', nome],
    queryFn: async () => {
      if (!nome) return [];
      const result = await api.get<TransacaoMinDTO[]>(`/transacoes?nomeReceptante=${nome}`);
      return result;
    },
    enabled: !!nome,
  });
}

export function useTransferencia() {
  const queryClient = useQueryClient();

  return useMutation({
    mutationFn: async (data: TransferenciaRequest) => {
      return api.post('/transacoes/transferencia', data);
    },
    onSuccess: () => {
      // Invalida as queries para recarregar os dados
      queryClient.invalidateQueries({ queryKey: ['transacoes'] });
      queryClient.invalidateQueries({ queryKey: ['usuarios'] });
    },
    onError: (error) => {
      console.error('Erro na transferência:', error);
    },
  });
}

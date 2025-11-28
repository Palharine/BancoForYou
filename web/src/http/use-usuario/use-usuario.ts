import { useQuery, useMutation, useQueryClient } from '@tanstack/react-query';
import { api } from './api';
import type { UsuarioMinDTO } from './types/types';

export function useUsuarios() {
  return useQuery({
    queryKey: ['usuarios'],
    queryFn: async () => {
      const data = await api.get<UsuarioMinDTO[]>('/conta/contas');
      return data;
    },
  });
}

export function useUsuarioByName(name: string | null) {
  return useQuery({
    queryKey: ['usuario', name],
    queryFn: async () => {
      if (!name) return null;
      const data = await api.get<UsuarioMinDTO>(`/conta/${name}`);
      return data;
    },
    enabled: !!name,
  });
}

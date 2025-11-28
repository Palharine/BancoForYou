import dayjs from '../path/dayjs-config';
import 'dayjs/locale/pt-br';
import relativeTime from 'dayjs/plugin/relativeTime';

const dataFormatada = dayjs().fromNow();
// Extende o dayjs com o plugin de tempo relativo
dayjs.extend(relativeTime);

// Define a localidade para pt-br
dayjs.locale('pt-br');

// Exporta o dayjs tipado para uso em outros arquivos .ts
export default dayjs;


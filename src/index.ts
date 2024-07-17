import { registerPlugin } from '@capacitor/core';

import type { SimulateClickPluginPlugin } from './definitions';

const SimulateClickPlugin = registerPlugin<SimulateClickPluginPlugin>(
  'SimulateClickPlugin',
  {
    web: () => import('./web').then(m => new m.SimulateClickPluginWeb()),
  },
);

export * from './definitions';
export { SimulateClickPlugin };

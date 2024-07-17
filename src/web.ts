import { WebPlugin } from '@capacitor/core';

import type { SimulateClickPluginPlugin } from './definitions';

export class SimulateClickPluginWeb
  extends WebPlugin
  implements SimulateClickPluginPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}

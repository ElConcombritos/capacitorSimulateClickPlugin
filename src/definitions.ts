export interface SimulateClickPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}

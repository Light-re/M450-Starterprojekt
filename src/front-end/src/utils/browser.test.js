import { reloadPage } from './browser';

describe('reloadPage', () => {
  test('does not reload in test environment by default', () => {
    const runtime = {
      location: {
        reload: jest.fn(),
      },
    };

    reloadPage(runtime);

    expect(runtime.location.reload).not.toHaveBeenCalled();
  });

  test('reloads when force flag is enabled', () => {
    const runtime = {
      location: {
        reload: jest.fn(),
      },
    };

    reloadPage(runtime, true);

    expect(runtime.location.reload).toHaveBeenCalledTimes(1);
  });
});

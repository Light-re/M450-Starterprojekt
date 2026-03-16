import { fireEvent, render, waitFor } from '@testing-library/react';
import ItemRow from './ItemRow';

describe('ItemRow', () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  test('sends DELETE request and reloads on success', async () => {
    globalThis.fetch = jest.fn(() => Promise.resolve({ ok: true }));

    const { container } = render(<ItemRow item={{ id: 7, name: 'Tablet' }} />);
    const deleteIcon = container.querySelector('svg');

    fireEvent.click(deleteIcon);

    await waitFor(() => {
      expect(globalThis.fetch).toHaveBeenCalledWith('http://localhost:8080/items/7', {
        method: 'DELETE',
      });
    });
  });

  test('logs an error on failed delete response', async () => {
    jest.spyOn(console, 'error').mockImplementation(() => {});
    globalThis.fetch = jest.fn(() => Promise.resolve({ ok: false }));

    const { container } = render(<ItemRow item={{ id: 9, name: 'Headset' }} />);
    const deleteIcon = container.querySelector('svg');

    fireEvent.click(deleteIcon);

    await waitFor(() => {
      expect(console.error).toHaveBeenCalled();
    });
  });
});

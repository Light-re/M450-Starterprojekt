import { test, expect } from '@playwright/test';

test('item can be added and is visible in list', async ({ page }) => {
  const itemName = `pw-item-${Date.now()}`;
  const items = [{ id: 1, name: 'existing-item' }];

  await page.route(/http:\/\/localhost:8080\/items(\/.*)?$/, async (route) => {
    const request = route.request();
    const method = request.method();
    const url = new URL(request.url());

    if (method === 'GET' && url.pathname === '/items') {
      await route.fulfill({
        status: 200,
        contentType: 'application/json',
        body: JSON.stringify(items),
      });
      return;
    }

    if (method === 'POST' && url.pathname.startsWith('/items/')) {
      const name = decodeURIComponent(url.pathname.replace('/items/', ''));
      const maxId = items.length ? Math.max(...items.map((item) => item.id)) : 0;
      items.push({ id: maxId + 1, name });
      await route.fulfill({ status: 200, body: '' });
      return;
    }

    if (method === 'DELETE' && url.pathname.startsWith('/items/')) {
      const id = Number(url.pathname.replace('/items/', ''));
      const index = items.findIndex((item) => item.id === id);
      if (index > -1) {
        items.splice(index, 1);
      }
      await route.fulfill({ status: 200, body: '' });
      return;
    }

    await route.fulfill({ status: 404, body: '' });
  });

  await page.goto('/');
  await page.getByRole('heading', { name: 'Add Item' }).waitFor();

  await page.locator('input[placeholder="Itemname"]').fill(itemName);
  await page.getByRole('button', { name: 'Add' }).click();

  await expect(page.getByText(itemName)).toBeVisible({ timeout: 15_000 });
  await page.screenshot({ path: '../../docs/images/playwright-item-added.png', fullPage: true });
});

test('item can be deleted from list', async ({ page }) => {
  const items = [{ id: 1, name: 'DeleteMe' }];

  await page.route(/http:\/\/localhost:8080\/items(\/.*)?$/, async (route) => {
    const request = route.request();
    const method = request.method();
    const url = new URL(request.url());

    if (method === 'GET' && url.pathname === '/items') {
      await route.fulfill({
        status: 200,
        contentType: 'application/json',
        body: JSON.stringify(items),
      });
      return;
    }

    if (method === 'DELETE' && url.pathname.startsWith('/items/')) {
      const id = Number(url.pathname.replace('/items/', ''));
      const index = items.findIndex((item) => item.id === id);
      if (index > -1) {
        items.splice(index, 1);
      }
      await route.fulfill({ status: 200, body: '' });
      return;
    }

    await route.fulfill({ status: 404, body: '' });
  });

  await page.goto('/');
  await page.getByRole('heading', { name: 'Item List' }).waitFor();
  await expect(page.getByText('DeleteMe')).toBeVisible();

  await page.locator('svg.bi-trash3').first().click();
  await expect(page.getByText('DeleteMe')).toBeHidden({ timeout: 15_000 });
  await page.screenshot({ path: '../../docs/images/playwright-item-deleted.png', fullPage: true });
});

/************************************************************
 *
 *                 OPEN TRANSACTIONS
 *
 *       Financial Cryptography and Digital Cash
 *       Library, Protocol, API, Server, CLI, GUI
 *
 *       -- Anonymous Numbered Accounts.
 *       -- Untraceable Digital Cash.
 *       -- Triple-Signed Receipts.
 *       -- Cheques, Vouchers, Transfers, Inboxes.
 *       -- Basket Currencies, Markets, Payment Plans.
 *       -- Signed, XML, Ricardian-style Contracts.
 *       -- Scripted smart contracts.
 *
 *  EMAIL:
 *  fellowtraveler@opentransactions.org
 *
 *  WEBSITE:
 *  http://www.opentransactions.org/
 *
 *  -----------------------------------------------------
 *
 *   LICENSE:
 *   This Source Code Form is subject to the terms of the
 *   Mozilla Public License, v. 2.0. If a copy of the MPL
 *   was not distributed with this file, You can obtain one
 *   at http://mozilla.org/MPL/2.0/.
 *
 *   DISCLAIMER:
 *   This program is distributed in the hope that it will
 *   be useful, but WITHOUT ANY WARRANTY; without even the
 *   implied warranty of MERCHANTABILITY or FITNESS FOR A
 *   PARTICULAR PURPOSE.  See the Mozilla Public License
 *   for more details.
 *
 ************************************************************/

#include "CmdCheckNym.hpp"

#include "../ot_made_easy_ot.hpp"

using namespace opentxs;
using namespace std;

CmdCheckNym::CmdCheckNym()
{
    command = "checknym";
    args[0] = "--server <server>";
    args[1] = "--mynym <nym>";
    args[2] = "--hisnym <nym>";
    category = catOtherUsers;
    help = "Download hisnym's public key.";
}

CmdCheckNym::~CmdCheckNym()
{
}

int32_t CmdCheckNym::runWithOptions()
{
    return run(getOption("server"), getOption("mynym"), getOption("hisnym"));
}

int32_t CmdCheckNym::run(string server, string mynym, string hisnym)
{
    if (!checkServer("server", server)) {
        return -1;
    }

    if (!checkNym("mynym", mynym)) {
        return -1;
    }

    if (!checkNym("hisnym", hisnym, false)) {
        return -1;
    }

    string response = MadeEasy::check_nym(server, mynym, hisnym);
    return processResponse(response, "check nym");
}

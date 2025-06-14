/*
 * Copyright (c) 2023 European Commission
 *
 * Licensed under the EUPL, Version 1.2 or - as soon they will be approved by the European
 * Commission - subsequent versions of the EUPL (the "Licence"); You may not use this work
 * except in compliance with the Licence.
 *
 * You may obtain a copy of the Licence at:
 * https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the Licence is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF
 * ANY KIND, either express or implied. See the Licence for the specific language
 * governing permissions and limitations under the Licence.
 */

package eu.europa.ec.commonfeature.util

import androidx.annotation.VisibleForTesting
import eu.europa.ec.commonfeature.model.DocumentOptionItemUi
import eu.europa.ec.commonfeature.model.DocumentUi
import eu.europa.ec.commonfeature.model.DocumentUiIssuanceState
import eu.europa.ec.commonfeature.ui.document_details.model.DocumentDetailsUi
import eu.europa.ec.corelogic.model.DocumentIdentifier
import eu.europa.ec.eudi.iso18013.transfer.response.DocItem
import eu.europa.ec.eudi.iso18013.transfer.response.ReaderAuth
import eu.europa.ec.eudi.iso18013.transfer.response.RequestedDocument
import eu.europa.ec.eudi.wallet.issue.openid4vci.Offer.TxCodeSpec
import eu.europa.ec.uilogic.component.AppIcons
import eu.europa.ec.uilogic.component.InfoTextWithNameAndImageData
import eu.europa.ec.uilogic.component.InfoTextWithNameAndValueData
import eu.europa.ec.uilogic.config.ConfigNavigation
import eu.europa.ec.uilogic.config.NavigationType
import eu.europa.ec.uilogic.navigation.DashboardScreens
import eu.europa.ec.uilogic.navigation.IssuanceScreens

@VisibleForTesting(otherwise = VisibleForTesting.NONE)
object TestsData {

    const val mockedPidDocName = "EU PID"
    const val mockedMdlDocName = "mDL"
    const val mockedPidId = "000001"
    const val mockedMdlId = "000002"
    const val mockedAgeVerificationId = "000003"
    const val mockedPhotoId = "000004"
    const val mockedUserFirstName = "JAN"
    const val mockedUserBase64Portrait = "SE"
    const val mockedDocUiNamePid = "National ID"
    const val mockedDocUiNameMdl = "mDL"
    const val mockedDocUiNameAge = "Age Verification"
    const val mockedDocUiNamePhotoId = "Photo ID"
    const val mockedDocUiNameSampleData = "Load Sample Documents"
    const val mockedNoUserFistNameFound = ""
    const val mockedNoUserBase64PortraitFound = ""
    const val mockedNoExpirationDateFound = ""
    const val mockedFormattedExpirationDate = "30 Mar 2050"
    const val mockedDocumentHasExpired = false
    const val mockedUserAuthentication = false
    const val mockedVerifierName = "EUDIW Verifier"
    const val mockedIssuerName = "EUDIW Issuer"
    const val mockedRequestRequiredFieldsTitle = "Verification Data"
    const val mockedRequestElementIdentifierNotAvailable = "Not available"
    const val mockedOfferedDocumentName = "Offered Document"
    const val mockedOfferedDocumentDocType = "mocked_offered_document_doc_type"
    const val mockedTxCodeSpecFourDigits = 4
    const val mockedSuccessTitle = "Success title"
    const val mockedSuccessSubtitle = "Success subtitle"
    const val mockedSuccessContentDescription = "Content description"
    const val mockedIssuanceErrorMessage = "Issuance error message"
    const val mockedInvalidCodeFormatMessage = "Invalid code format message"
    const val mockedWalletActivationErrorMessage = "Wallet activation error message"
    const val mockedPrimaryButtonText = "Primary button text"
    const val mockedRouteArguments = "mockedRouteArguments"
    const val mockedTxCode = "mockedTxCode"

    const val mockedPidDocType = "eu.europa.ec.eudi.pid.1"
    const val mockedPidNameSpace = "eu.europa.ec.eudi.pid.1"
    const val mockedMdlDocType = "org.iso.18013.5.1.mDL"
    const val mockedMdlNameSpace = "org.iso.18013.5.1"
    const val mockedAgeVerificationDocType = "eu.europa.ec.eudi.pseudonym.age_over_18.1"
    const val mockedAgeVerificationNameSpace = "eu.europa.ec.eudi.pseudonym.age_over_18.1"
    const val mockedPhotoIdDocType = "org.iso.23220.2.photoid.1"
    const val mockedPhotoIdNameSpace = "org.iso.23220.2.photoid.1"

    const val mockedUriPath1 = "eudi-wallet://example.com/path1"
    const val mockedUriPath2 = "eudi-wallet://example.com/path2"

    val mockedValidReaderAuth = ReaderAuth(
        readerAuth = byteArrayOf(),
        readerSignIsValid = true,
        readerCertificateChain = listOf(),
        readerCertificatedIsTrusted = true,
        readerCommonName = mockedVerifierName
    )

    val mockedPidWithBasicFieldsDocRequest = RequestedDocument(
        documentId = mockedPidId,
        requestedItems = mapOf(
            DocItem(
                namespace = mockedPidNameSpace,
                elementIdentifier = "family_name"
            ) to false,
            DocItem(
                namespace = mockedPidNameSpace,
                elementIdentifier = "given_name"
            ) to false,
            DocItem(
                namespace = mockedPidNameSpace,
                elementIdentifier = "age_over_18"
            ) to false,
            DocItem(
                namespace = mockedPidNameSpace,
                elementIdentifier = "age_over_65"
            ) to false,
            DocItem(
                namespace = mockedPidNameSpace,
                elementIdentifier = "age_birth_year"
            ) to false,
            DocItem(
                namespace = mockedPidNameSpace,
                elementIdentifier = "birth_city"
            ) to false,
            DocItem(
                namespace = mockedPidNameSpace,
                elementIdentifier = "gender"
            ) to false,
            DocItem(
                namespace = mockedPidNameSpace,
                elementIdentifier = "expiry_date"
            ) to false,
            DocItem(
                namespace = mockedPidNameSpace,
                elementIdentifier = "portrait",
            ) to false,
            DocItem(
                namespace = mockedPidNameSpace,
                elementIdentifier = "issuing_country",
            ) to false,
        ),
        readerAuth = mockedValidReaderAuth
    )

    val mockedMdlWithBasicFieldsDocRequest = RequestedDocument(
        documentId = mockedMdlId,
        requestedItems = mapOf(
            DocItem(
                namespace = mockedMdlNameSpace,
                elementIdentifier = "family_name"
            ) to false,
            DocItem(
                namespace = mockedMdlNameSpace,
                elementIdentifier = "given_name"
            ) to false,
            DocItem(
                namespace = mockedMdlNameSpace,
                elementIdentifier = "birth_place"
            ) to false,
            DocItem(
                namespace = mockedMdlNameSpace,
                elementIdentifier = "expiry_date"
            ) to false,
            DocItem(
                namespace = mockedMdlNameSpace,
                elementIdentifier = "portrait"
            ) to false,
            DocItem(
                namespace = mockedMdlNameSpace,
                elementIdentifier = "driving_privileges"
            ) to false,
            DocItem(
                namespace = mockedMdlNameSpace,
                elementIdentifier = "signature_usual_mark"
            ) to false,
            DocItem(
                namespace = mockedMdlNameSpace,
                elementIdentifier = "sex"
            ) to false,
        ),
        readerAuth = mockedValidReaderAuth
    )

    val mockedValidPidWithBasicFieldsRequestDocument = mockedPidWithBasicFieldsDocRequest

    val mockedValidMdlWithBasicFieldsRequestDocument = mockedMdlWithBasicFieldsDocRequest

    val mockedFullPidUi = DocumentUi(
        documentId = mockedPidId,
        documentName = mockedDocUiNamePid,
        documentIdentifier = DocumentIdentifier.PID,
        documentExpirationDateFormatted = mockedFormattedExpirationDate,
        documentHasExpired = mockedDocumentHasExpired,
        documentImage = "",
        documentDetails = emptyList(),
        documentIssuanceState = DocumentUiIssuanceState.Issued,
    )

    val mockedPendingPidUi = mockedFullPidUi.copy(
        documentIssuanceState = DocumentUiIssuanceState.Pending
    )

    val mockedUnsignedPidUi = mockedFullPidUi.copy(
        documentName = mockedPidDocName,
        documentIssuanceState = DocumentUiIssuanceState.Pending,
        documentIdentifier = DocumentIdentifier.OTHER(
            nameSpace = "",
            docType = mockedFullPidUi.documentIdentifier.docType
        ),
        documentExpirationDateFormatted = ""
    )

    val mockedBasicPidUi = mockedFullPidUi.copy(
        documentDetails = listOf(
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "birth_city",
                        infoValues = arrayOf("KATRINEHOLM")
                    )
            ),
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "gender",
                        infoValues = arrayOf("male")
                    )
            ),
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "age_over_18",
                        infoValues = arrayOf("yes")
                    )
            ),
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "age_birth_year",
                        infoValues = arrayOf("1985")
                    )
            ),
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "expiry_date",
                        infoValues = arrayOf("30 Mar 2050")
                    )
            ),
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "given_name",
                        infoValues = arrayOf("JAN")
                    )
            ),
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "family_name",
                        infoValues = arrayOf("ANDERSSON")
                    )
            ),
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "age_over_65",
                        infoValues = arrayOf("no")
                    )
            ),
        ),
        userFullName = "JAN ANDERSSON"
    )

    val mockedFullMdlUi = DocumentUi(
        documentId = mockedMdlId,
        documentName = mockedDocUiNameMdl,
        documentIdentifier = DocumentIdentifier.MDL,
        documentExpirationDateFormatted = mockedFormattedExpirationDate,
        documentHasExpired = mockedDocumentHasExpired,
        documentImage = "",
        documentDetails = emptyList(),
        documentIssuanceState = DocumentUiIssuanceState.Issued,
    )

    val mockedPendingMdlUi = mockedFullMdlUi.copy(
        documentIssuanceState = DocumentUiIssuanceState.Pending
    )

    val mockedBasicMdlUi = mockedFullMdlUi.copy(
        documentDetails = listOf(
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "driving_privileges",
                        infoValues = arrayOf(
                            "issue_date: 1 Jul 2010\n" +
                                    "expiry_date: 30 Mar 2050\n" +
                                    "vehicle_category_code: A\n" +
                                    "issue_date: 19 May 2008\n" +
                                    "expiry_date: 30 Mar 2050\n" +
                                    "vehicle_category_code: B"
                        )
                    )
            ),
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "expiry_date",
                        infoValues = arrayOf("30 Mar 2050")
                    )
            ),
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "sex",
                        infoValues = arrayOf("male")
                    )
            ),
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "birth_place",
                        infoValues = arrayOf("SWEDEN")
                    )
            ),
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "given_name",
                        infoValues = arrayOf("JAN")
                    )
            ),
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "portrait",
                        infoValues = arrayOf("Shown above")
                    )
            ),
            DocumentDetailsUi.DefaultItem(
                itemData = InfoTextWithNameAndValueData
                    .create(
                        title = "family_name",
                        infoValues = arrayOf("ANDERSSON")
                    )
            ),
            DocumentDetailsUi.SignatureItem(
                itemData = InfoTextWithNameAndImageData(
                    title = "signature_usual_mark",
                    base64Image = "SE"
                )
            ),
        ),
        userFullName = "JAN ANDERSSON"
    )

    val mockedMdlUiWithNoUserNameAndNoUserImage: DocumentUi = mockedFullMdlUi

    val mockedMdlUiWithNoExpirationDate: DocumentUi = mockedFullMdlUi.copy(
        documentExpirationDateFormatted = mockedNoExpirationDateFound
    )

    val mockedFullDocumentsUi: List<DocumentUi> = listOf(
        mockedFullPidUi, mockedFullMdlUi
    )

    val mockedPidOptionItemUi = DocumentOptionItemUi(
        text = mockedDocUiNamePid,
        icon = AppIcons.Id,
        type = DocumentIdentifier.PID,
        available = true
    )

    val mockedMdlOptionItemUi = DocumentOptionItemUi(
        text = mockedDocUiNameMdl,
        icon = AppIcons.Id,
        type = DocumentIdentifier.MDL,
        available = true
    )

    val mockedAgeOptionItemUi = DocumentOptionItemUi(
        text = mockedDocUiNameAge,
        icon = AppIcons.Id,
        type = DocumentIdentifier.AGE,
        available = true
    )

    val mockedPhotoIdOptionItemUi = DocumentOptionItemUi(
        text = mockedDocUiNamePhotoId,
        icon = AppIcons.Id,
        type = DocumentIdentifier.PHOTOID,
        available = true
    )

    val mockedSampleDataOptionItemUi = DocumentOptionItemUi(
        text = mockedDocUiNameSampleData,
        icon = AppIcons.Id,
        type = DocumentIdentifier.SAMPLE,
        available = true
    )

    val mockedConfigNavigationTypePop = ConfigNavigation(navigationType = NavigationType.Pop)
    val mockedConfigNavigationTypePush = ConfigNavigation(
        navigationType = NavigationType.PushRoute(
            route = DashboardScreens.Dashboard.screenRoute,
            popUpToRoute = IssuanceScreens.AddDocument.screenRoute
        )
    )
    val mockedConfigNavigationTypePopToScreen = ConfigNavigation(
        navigationType = NavigationType.PopTo(
            screen = DashboardScreens.Dashboard
        )
    )

    val mockedOfferTxCodeSpecFourDigits =
        TxCodeSpec(
            inputMode = TxCodeSpec.InputMode.NUMERIC,
            length = mockedTxCodeSpecFourDigits
        )
}